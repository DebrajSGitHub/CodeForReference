package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class Test02ReturnDefaultValue {

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
		
		System.out.println("List of rooms : " + roomServiceMock.getAvailableRooms()) ;
		System.out.println("Object Returned: " + roomServiceMock.findAvailableRoomId(null));
		System.out.println("Room count Primitive" + roomServiceMock.getRoomCount());
	}

	@Test
	void should_CountAvailablePlaces() {
		//given
		
		int expected=0;
		
		//when
		
		int actual= bookingService.getAvailablePlaceCount();
		//then
		
		assertEquals(expected, actual);
	}




}