package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class Test05ThrowingException {

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
	void should_ThrowException_when_NoRoomAvailable() {

		// give
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, false);

		when(this.roomServiceMock.findAvailableRoomId(bookingRequest))
		.thenThrow(BusinessException.class);
		// when
		
		Executable executable = ()-> bookingService.makeBooking(bookingRequest);

		
		// then
		
		assertThrows(BusinessException.class, executable);
		
		
	}

}
