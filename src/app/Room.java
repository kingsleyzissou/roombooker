package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helpers.RoomState;

public class Room {

	private int roomNumber;
	private RoomCategory category;
	private ArrayList<Booking> bookings;
	private RoomState state = RoomState.UNOCCUPIED_DIRTY;

	public Room(int roomNumber, RoomCategory category) {
		this.setRoomNumber(roomNumber);
		this.setCategory(category);
		this.bookings = new ArrayList<>();
	}

	/**
	 * Check if the room is available between two dates and of the correct category
	 * 
	 * @boolean
	 */
	public boolean isAvailable(Date startDate, Date endDate, RoomCategory category) {
		// if incorrect category, room is not available
		if (!this.category.equals(category))
			return false;
		for (Booking booking : bookings) {
			// check if the desired start date
			// is inbetween a booking start and end date
			if (startDate.after(booking.getStartDate()) && startDate.before(booking.getEndDate()))
				return false;
			// check if the desired end date
			// is inbetween a booking start and end date
			if (endDate.after(booking.getStartDate()) && endDate.before(booking.getEndDate()))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return the price for the room
	 */
	public double getPrice(Date startDate, Date endDate) {
		return this.category.getPrice(startDate, endDate);
	}

	/**
	 * Add a booking to the booking list
	 */
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}

	/**
	 * Remove a booking from the booking list
	 */
	public void removeBooking(Booking booking) {
		bookings.remove(booking);
	}

	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the category
	 */
	public RoomCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(RoomCategory category) {
		this.category = category;
	}

	/**
	 * @return the state
	 */
	public RoomState getState() {
		return state;
	}

	/**
	 * @param state the roomstate to update
	 */
	public void updateState(RoomState state) {
		this.state = state;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}

}
