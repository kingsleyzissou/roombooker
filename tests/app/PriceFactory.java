package app;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Date;
import java.util.List;

import helpers.Season;

public class PriceFactory {
	
//	private Price summerSingle, winterSingle, autumnSingle, springSingle;
//	private Price summerDouble, winterDouble, autumnDouble, springDouble;
	
//	private List<Date> startDates = new ArrayList<>();
//	private List<Date> endDates =  new ArrayList<>();
	private List<Season> seasons = new ArrayList<>();
	
	public PriceFactory(RoomCategory category, int ...amounts)  {
		Collections.addAll(seasons, Season.SUMMER, Season.SPRING, Season.AUTUMN, Season.WINTER);
		int index = 0;
		for(int amount : amounts) {
			if(index < seasons.size()) {
				Season season = seasons.get(index);
				new Price(season.startDate(), season.endDate(), amount, category);
			}
			index++;
		}
	}

}
