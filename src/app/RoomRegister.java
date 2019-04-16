package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RoomRegister {

	public List<Room> rooms;
	public List<RoomCategory> categories;


	public RoomRegister() {
		rooms = new ArrayList<>();
		categories = new ArrayList<>();
	}

	/**
	 * @return the first available room that meets date and category criteria
	 */
	public Room getAvailableRoom(Date startDate, Date endDate, RoomCategory category) {

		for (Room room : rooms) {
			if (room.isAvailable(startDate, endDate, category))
				return room;
		}

		return null;

	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void addAllRooms(Room ...room) {
		Collections.addAll(rooms, room);
	}
	
	public void addCategory(RoomCategory category) {
		categories.add(category);
	}
	
	public void addAllCategories(RoomCategory ...category) {
		Collections.addAll(categories, category);
	}

}
