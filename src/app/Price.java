package app;

import java.util.Calendar;
import java.util.Date;

public class Price {

	private Date startDate;
	private Date endDate;
	private double price;
	private RoomCategory category;

	public Price(Date startDate, Date endDate, double price, RoomCategory category) {
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setPrice(price);
		this.setCategory(category);
		category.addPrice(this);
	}

	/**
	 * Calculate price for the days that fall in this price window dates
	 * 
	 * @param start date to be compared to
	 * @param end   date to be compared to
	 * @return price for days spent in this price window
	 * 
	 */
	public double calculatePrice(Date start, Date end) {
		double total = 0.0;
		Date d = start;
		while (d.before(end)) {
			if (isInDateRange(d)) {
				total += getPrice();
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
		}
		return total;
	}

	/**
	 * Check if a booking falls in this price range, based on the date
	 * 
	 * @param date to be checked
	 * @return boolean
	 * 
	 */
	public boolean isInDateRange(Date date) {
		return (date.after(startDate) && date.before(endDate));
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 * 
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 * 
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 * 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the price
	 * 
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 * 
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the category
	 * 
	 */
	public RoomCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 * 
	 */
	public void setCategory(RoomCategory category) {
		this.category = category;
	}

}
