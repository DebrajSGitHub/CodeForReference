package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Test11Annotations {
	
	@InjectMocks
	private BookingService bookingService;
	
	@Mock
	private PaymentService paymentServiceMock;
	@Mock
	private RoomService roomServiceMock;
	@Spy
	private BookingDAO bookingDaoMock;
	@Mock
	private MailSender mailSenderMock;
	
	@Captor
	private ArgumentCaptor<Double> doubleCaptor;
	private ArgumentCaptor<BookingRequest> bookingRequestCaptor;

	/*
	 * @BeforeEach void setup() {
	 * 
	 * this.paymentServiceMock = mock(PaymentService.class); this.roomServiceMock =
	 * mock(RoomService.class); this.bookingDaoMock = mock(BookingDAO.class);
	 * this.mailSenderMock = mock(MailSender.class);
	 * 
	 * this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
	 * bookingDaoMock, mailSenderMock);
	 * 
	 * this.doubleCaptor = ArgumentCaptor.forClass(Double.class); }
	 */

	@Test
	void should_PayCorrectPrice_When_InputOk() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);

		
		// when

		bookingService.makeBooking(bookingRequest);
		// then
		
		verify(paymentServiceMock,times(1)).pay(eq(bookingRequest),doubleCaptor.capture());
		
		double capturedArgument = doubleCaptor.getValue();
		
		System.out.println(capturedArgument);
		
		assertEquals(600.0, capturedArgument);


	}
	
	@Test
	void should_PayCorrectPrice_When_MultipleCalls() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
				2, true);
		BookingRequest bookingRequest2 = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 15),
				2, true);
		
		List<Double> expectedValues = Arrays.asList(600.0 , 100.0);
		// when

		bookingService.makeBooking(bookingRequest);
		bookingService.makeBooking(bookingRequest2);
		// then
		
		verify(paymentServiceMock,times(2)).pay(any(),doubleCaptor.capture());
		
		List<Double> capturedArgument = doubleCaptor.getAllValues();
		
		System.out.println(capturedArgument);
		
		//assertEquals(600.0, capturedArgument);
		
		assertEquals(expectedValues, capturedArgument);


	}
	
	
	
	

}
