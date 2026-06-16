package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.time.LocalDate;
import java.time.Month;

class Test06Matchers {

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
	void should_NotCompleteBooking_when_PriceToHigh() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);
		
		when(this.paymentServiceMock.pay(any(), anyDouble())).thenThrow(BusinessException.class);
		
		//when(this.paymentServiceMock.pay(any(), eq(600.0))).thenThrow(BusinessException.class);

		
		// when
		
		Executable executable = ()-> bookingService.makeBooking(bookingRequest);

		System.out.println(executable);
		// then
		
		assertThrows(BusinessException.class, executable);
		
		
	}

}
