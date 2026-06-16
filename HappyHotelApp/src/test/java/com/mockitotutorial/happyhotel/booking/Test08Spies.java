package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;

import java.time.LocalDate;
import java.time.Month;

class Test08Spies {

	private BookingService bookingService;

	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDaoMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {

		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDaoMock = spy(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDaoMock, mailSenderMock);
	}

	@Test
	void should_MakeBooking_when_InputOk() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);

		
		// when

		String bookingid = bookingService.makeBooking(bookingRequest);
		// then
		
		verify(bookingDaoMock).save(bookingRequest);
		System.out.println("bookingId : " + bookingid);
		
	}
	
	
	@Test
	void should_Cancelooking_when_InputOk() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);
		bookingRequest.setRoomId("1.4");
		
		String bookingId =  "1";
		
		// when
		doReturn(bookingRequest).when(bookingDaoMock).get(bookingId);
		bookingService.cancelBooking(bookingId);
		// then
		
		
		
	}
	
	

}
