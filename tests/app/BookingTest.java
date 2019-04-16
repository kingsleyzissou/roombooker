package app;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	private RoomRegister rooms = new RoomRegister();
	private Customer customer;
	private RoomCategory doubleRoom, singleRoom;
	private Room r1, r2, r3, r4;
	private Date startDate, endDate;

	
	@Before
	public void setup() {
		
		customer = new Customer("John", "Doe", "1234", "jd@test.com", "1234", "9999888877776666");
		
		doubleRoom = new RoomCategory("Double Room", true, true, true, true, 1);
		singleRoom = new RoomCategory("Single Room", true, true, true, true, 1);
		
		rooms.addAllCategories(doubleRoom, singleRoom);
		
		r1 = new Room(1, singleRoom);
		r2 = new Room(2, singleRoom);
		r3 = new Room(3, doubleRoom);
		r4 = new Room(4, doubleRoom);
		rooms.addAllRooms(r1, r2, r3, r4);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 15);
		
		startDate = cal.getTime();
		
		cal.set(Calendar.DATE, 20);
		endDate = cal.getTime();
		
		new  PriceFactory(singleRoom, 100, 80, 50, 80);
		new  PriceFactory(doubleRoom, 140, 110, 75, 100);
				
		
	}
	
	
	@Test
	public void firstAvailableSingleRoomIsR1() {
		assertEquals(r1, rooms.getAvailableRoom(startDate, endDate, singleRoom));
	}
	
	
	@Test
	public void firstAvailableDoubleRoomIsR3() {
		assertEquals(r3, rooms.getAvailableRoom(startDate, endDate, doubleRoom));
	}
	
	@Test
	public void newBookingIsAddedToCustomerBookingList() {
		Room room = rooms.getAvailableRoom(startDate, endDate, singleRoom);
		Booking booking = new Booking(customer, startDate, endDate, room);
		assertTrue(room.getBookings().contains(booking));
	}
	
	@Test
	public void newBookingIsAddedToRoomBookingList() {
		Room room = rooms.getAvailableRoom(startDate, endDate, singleRoom);
		Booking booking = new Booking(customer, startDate, endDate, room);
		assertTrue(customer.getBookings().contains(booking));
	}
	
	@Test
	public void unpaidBookingHasBalanceThatMatchesRoomPrice() {
		Room room = rooms.getAvailableRoom(startDate, endDate, singleRoom);
		Booking booking = new Booking(customer, startDate, endDate, room);
		double price = room.getCategory().getPrice(startDate, endDate);
		assertEquals(price, booking.getBalance(), 0);
	}
	

}
