package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Test16FinalMethods {

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
	void should_CountAvailablePlaces_When_OneRoomisAvailable() {
		// Given
		when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1", 2)));
		int expected = 2;

		// When

		int actual = bookingService.getAvailablePlaceCount();
		// Then

		assertEquals(expected, actual);
	}

	@Test
	void should_CountAvailablePlaces_When_MultipleRoomsisAvailable() {
		// Given
		
		List<Room> rooms = Arrays.asList(new Room("Room 1",2),new Room("Room 2 ", 5));
		when(this.roomServiceMock.getAvailableRooms()).thenReturn(rooms);
		int expected = 7;

		// When

		int actual = bookingService.getAvailablePlaceCount();
		// Then

		assertEquals(expected, actual);

	}

}