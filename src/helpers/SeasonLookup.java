package helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonLookup {
	
	private List<Season> lookup  = new ArrayList<>();
	
	public SeasonLookup() {
		Collections.addAll(lookup, Season.WINTER, Season.WINTER, Season.SPRING, 
				Season.SPRING, Season.SPRING, Season.SUMMER, Season.SUMMER, 
				Season.SUMMER, Season.AUTUMN, Season.AUTUMN, Season.AUTUMN,
				Season.WINTER
		);
	}
	
	public Season getSeason(int month) {
		return lookup.get(month);
	}

}
