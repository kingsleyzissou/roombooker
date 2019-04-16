package helpers;

import java.util.Calendar;
import java.util.Date;

public enum Season {
	
	SUMMER {
		@Override
		public Date startDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 5);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
		@Override
		public Date endDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 8);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
	},
	WINTER {
		@Override
		public Date startDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 11);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
		@Override
		public Date endDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2020);
			cal.set(Calendar.MONTH, 0);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
	},
	SPRING {
		@Override
		public Date startDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 2);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
		@Override
		public Date endDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 5);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
	},
	AUTUMN {
		@Override
		public Date startDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 8);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
		@Override
		public Date endDate() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2019);
			cal.set(Calendar.MONTH, 11);
			cal.set(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
	};
	
	public abstract Date startDate();
	public abstract Date endDate();
	

}
