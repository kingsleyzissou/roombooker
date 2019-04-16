package app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

	private UUID uuid;
	private String name;
	private String lastName;
	private String phone;
	private String email;
	private String cardNumber;
	private ArrayList<Booking> bookingList;

	@SuppressWarnings("unused")
	private String password;

	public Customer(String name, String lastName, String phone, String email, String password, String cardNumber) {
		this.setUuid(UUID.randomUUID());
		this.setLastName(name);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setEmail(email);
		this.setPassword(password);
		this.bookingList = new ArrayList<>();
	}

	/**
	 * Send an email to the customer
	 * 
	 * @param subject of the message
	 * @param message body of the message
	 */
	public void notify(String subject, String message) {
		String to = email;
		String from = "bookings@our-hotel-is-cool.com";
		// Email pseudocode
		// sendEmail(from, to, subject, message);
		System.out.println(from);
		System.out.println(to);
		System.out.println(subject);
		System.out.println(message);
	}

	/**
	 * Add a booking to the customer's booking list
	 */
	public void addBooking(Booking booking) {
		bookingList.add(booking);
	}

	/**
	 * @return the uuid
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public List<Booking> getBookings() {
		return bookingList;
	}

}
