package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Test14StaticMethod { //BDD --> Behaviour driven development
	
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
	void should_CalculateCorrectPrice() {
		// given
		try (MockedStatic<CurrencyConverter> mockedConverter= mockStatic(CurrencyConverter.class)){
			
			BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, Month.MAY, 14), LocalDate.of(2023, Month.MAY, 20),
					2, false);
			double expected =600.0;
			mockedConverter.when(()-> CurrencyConverter.toEuro(anyDouble())).thenReturn(600.0);
			
		
		
		
		
		
		// when
		
		double actual = bookingService.calculatePriceEuro(bookingRequest);

		
		// then
		assertEquals(expected , actual);
		}
		
	}
	
	
	
	
	

}
