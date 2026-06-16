package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Test17MockingConstruction {

	private RoomService roomServiceMock;

	@Test
	void should_ShowRoom_When_BigCapacity(){
		
		//given
		
		try(MockedConstruction<Room> mockConstruction =
				Mockito.mockConstruction(Room.class, (mock,context)->{
					
				when(mock.getCapacity()).thenReturn(6);
				when(mock.getId()).thenReturn("5.0");
				
				})){
			
			this.roomServiceMock = new RoomService();
			
			BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2026, Month.MAY, 05), LocalDate.of(2026, Month.MAY, 06), 6, false);
		
			
			//when
			String actualRoomId = roomServiceMock.findAvailableRoomId(bookingRequest);
			
			//then 
			
			assertEquals("5.0", actualRoomId);
			
			
		}
		
		
	}
	

	

}