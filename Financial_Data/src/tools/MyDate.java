package tools;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String date) {
		//Need to take apart the String and make
		//it into the variables
		String[] splitter = date.split("/");
		
		month = Integer.parseInt(splitter[0]);
		day = Integer.parseInt(splitter[1]);
		year = Integer.parseInt(splitter[2]);
	}
	
	public String toString() {
		return (" " + month + "/" + day + "/" + year);
	}
	
	public boolean equals(MyDate myDate) {
		if(this.day == myDate.getDay() &&
				this.month == myDate.getMonth() &&
				this.year == myDate.getYear()){
			return true;
			
		} else {
			return false;
		}
	}
	
	public boolean lessThan(MyDate myDate) {
		if(this.getYear() < myDate.getYear()) {
			return true;
		} else if(this.getYear() == myDate.getYear()) {
			if(this.getMonth() < myDate.getMonth()) {
				return true;
			} else if(this.getMonth() == myDate.getMonth()) {
				if(this.getDay() < myDate.getDay()) {
					return true;
				} else if(this.getDay() == myDate.getDay()) {
					return false;
				} else {
					return false;
				}
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean greaterThan(MyDate myDate) {
		if(this.getYear() > myDate.getYear()) {
			return true;
		} else if(this.getYear() == myDate.getYear()) {
			if(this.getMonth() > myDate.getMonth()) {
				return true;
			} else if(this.getMonth() == myDate.getMonth()) {
				if(this.getDay() > myDate.getDay()) {
					return true;
				} else if(this.getDay() == myDate.getDay()) {
					return false;
				} else {
					return false;
				}
			}else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
