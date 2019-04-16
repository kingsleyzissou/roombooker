package app;

public class Payment {

	private Booking booking;
	private double amount;
	private String paymentType;
	private String cardDetails;

	public Payment(Booking booking, double amount, String paymentType) {
		this.setBooking(booking);
		this.setAmount(amount);
		this.setPaymentType(paymentType);
		String cardDetails = booking.getCustomer().getCardNumber();
		this.setCardDetails(cardDetails);
		booking.addPayment(this);
		notifyCustomer();
	}

	/**
	 * Notify customer of payment
	 * 
	 */
	public void notifyCustomer() {
		String subject = paymentType + " notification";
		String card = cardDetails.substring(cardDetails.length() - 4);
		// Pseudo code for sending customer an email
		String message = "A payment of " + amount + " has been made. (Card ending: " + card + ")";
		booking.getCustomer().notify(subject, message);
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the cardDetails
	 */
	public String getCardDetails() {
		return cardDetails;
	}

	/**
	 * @param cardDetails the cardDetails to set
	 */
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

}
