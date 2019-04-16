package app;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	private Customer customer;
	private ArrayList<RoomCategory> categories = new ArrayList();
	private ArrayList<Room> rooms = new ArrayList();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		app();
	}
	
	public void app() {
		customer = new Customer("John", "Doe", "1234", "jd@test.com", "1234", "9999888877776666");
		
		RoomCategory doubleRoom = new RoomCategory("Double Room", true, true, true, true, 1);
		RoomCategory singleRoom = new RoomCategory("Single Room", true, true, true, true, 1);
		Collections.addAll(categories, singleRoom, doubleRoom);
		
		Room r1 = new Room(1, singleRoom);
		Room r2 = new Room(2, singleRoom);
		Room r3 = new Room(3, doubleRoom);
		Room r4 = new Room(4, doubleRoom);
		Collections.addAll(rooms, r1, r2, r3, r4);

	}
	

}
