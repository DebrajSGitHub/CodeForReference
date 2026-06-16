package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class Test01FirstMock {

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
	void should_CalculateCorrectPrice_when_CorrectInput() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, false);

		double expected = 6 * 2 * 50.0;
		// when

		double actual = bookingService.calculatePrice(bookingRequest);
		System.out.println("actual" + actual);
		// then
		
		assertEquals(expected, actual);
		
	}

}
