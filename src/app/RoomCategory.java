package app;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class RoomCategory {

	private UUID uuid;
	private String name;
	private boolean wifi;
	private boolean minibar;
	private boolean hasView;
	private boolean blackOutBlinds;
	private int floor;
	private List<Price> priceList;

	public RoomCategory(String name, boolean wifi, boolean minibar, boolean hasView, boolean blackOutBlinds,
			int floor) {
		this.setName(name);
		this.setWifi(wifi);
		this.setMinibar(minibar);
		this.setHasView(hasView);
		this.setBlackOutBlinds(blackOutBlinds);
		this.setFloor(floor);
		priceList = new ArrayList<>();
	}

	/**
	 * Get the price for the stay, based on the various different prices
	 * 
	 * @param startDate
	 * @param endDate
	 * @return price for the stay
	 */
	public double getPrice(Date startDate, Date endDate) {
		double total = 0.0;
		for (Price price : this.priceList) {
			total += price.calculatePrice(startDate, endDate);
		}
		return total;
	}

	/**
	 * Add price to priceList
	 */
	public void addPrice(Price price) {
		priceList.add(price);
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
	 * @return the wifi
	 */
	public boolean isWifi() {
		return wifi;
	}

	/**
	 * @param wifi the wifi to set
	 */
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	/**
	 * @return the minibar
	 */
	public boolean isMinibar() {
		return minibar;
	}

	/**
	 * @param minibar the minibar to set
	 */
	public void setMinibar(boolean minibar) {
		this.minibar = minibar;
	}

	/**
	 * @return the hasView
	 */
	public boolean isHasView() {
		return hasView;
	}

	/**
	 * @param hasView the hasView to set
	 */
	public void setHasView(boolean hasView) {
		this.hasView = hasView;
	}

	/**
	 * @return the blackOutBlinds
	 */
	public boolean isBlackOutBlinds() {
		return blackOutBlinds;
	}

	/**
	 * @param blackOutBlinds the blackOutBlinds to set
	 */
	public void setBlackOutBlinds(boolean blackOutBlinds) {
		this.blackOutBlinds = blackOutBlinds;
	}

	/**
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}

}
