package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;

import java.time.LocalDate;
import java.time.Month;

class Test07VerifyingBehaviour {

	private BookingService bookingService;

	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDaoMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {

		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDaoMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDaoMock, mailSenderMock);
	}

	@Test
	void should_InvokePayment_when_Prepaid() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);

		
		// when

		bookingService.makeBooking(bookingRequest);
		// then
		
		verify(paymentServiceMock,times(1)).pay(bookingRequest, 600.0);
		verifyNoMoreInteractions(paymentServiceMock);
	}
	
	
	
	@Test
	void should_NotInvokePayment_when_NotPrepaid() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, false);

		
		// when
		bookingService.makeBooking(bookingRequest);
		
		// then
		
		verify(paymentServiceMock, never()).pay(any(), anyDouble());
		
	}

}
