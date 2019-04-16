package app;

import java.util.UUID;

import helpers.BookingState;
import helpers.RoomState;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private UUID uuid;
	private Customer customer;
	private Date startDate;
	private Date endDate;
	private Room room;
	private BookingState state = BookingState.PENDING;
	private ArrayList<Payment> payments;

	public Booking(Customer customer, Date startDate, Date endDate, Room room) {
		setUuid(UUID.randomUUID());
		this.setCustomer(customer);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setRoom(room);
		customer.addBooking(this);
		room.addBooking(this);
		payments = new ArrayList<>();
	}

	/**
	 * Modify the booking
	 * 
	 * @param startDate
	 * @param endDate
	 * @param room
	 */
	public void modifyBooking(Date startDate, Date endDate, Room room) {
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.room.removeBooking(this);
		room.addBooking(this);
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return room.getCategory().getPrice(startDate, endDate);
	}

	/**
	 * @return the price
	 */
	public double getBalance() {
		double total = 0;
		for (Payment payment : payments) {
			total += payment.getAmount();
		}
		return getPrice() - total;
	}

	/**
	 * Make a payment
	 * 
	 * @param amount to be paid
	 */
	public void makePayment(double amount) {
		this.makePayment(amount, "normal");
	}

	/**
	 * Make a payment with type (e.g. refund)
	 * 
	 * @param amount to be paid
	 * @param type   of payment
	 */
	public void makePayment(double amount, String type) {
		new Payment(this, amount, type);
	}

	/**
	 * Issue a refund
	 * 
	 */
	public void issueRefund() {
		this.makePayment(this.getBalance() * (-1), "refund");
	}

	/**
	 * Check if there is any balance
	 * 
	 * @return boolean
	 */
	public boolean fullyPaid() {
		return (getBalance() == 0);
	}

	/**
	 * Check in the customer and update room state
	 * 
	 */
	public void checkIn() {
		room.updateState(RoomState.OCCUPIED);
	}

	/**
	 * Check out the customer and update room state
	 * 
	 */
	public void checkOut() {
		room.updateState(RoomState.UNOCCUPIED_DIRTY);
	}

	/**
	 * Add payment to payment list
	 * 
	 * @param payment
	 * 
	 */
	public void addPayment(Payment payment) {
		payments.add(payment);
	}

	/**
	 * Cancel the booking
	 * 
	 */
	public void cancelBooking() {
		issueRefund();
		room.removeBooking(this);
		this.updateState(BookingState.CANCELLED);
	}

	/**
	 * @return the uuid
	 * 
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the category
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param category the category to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}


	/**
	 * @return the state
	 */
	public BookingState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void updateState(BookingState state) {
		this.state = state;
	}

}
