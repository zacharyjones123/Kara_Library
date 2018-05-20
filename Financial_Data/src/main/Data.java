package main;

import tools.MyDate;

public class Data {
	
	private String name;
	private MyDate date;
	private String time;
	private String subject;
	private String type;
	private String rating;
	private double money;
	
	public Data(String name, String date, String time, String subject, String type, String rating) {
		this.name = name;
		this.date = new MyDate(date);
		this.time = time;
		this.subject = subject;
		this.type = type;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Data [name=" + name + ", date=" + date + ", time=" + time + ", subject=" + subject + ", type=" + type
				+ ", rating=" + rating + ", money=" + money + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getDate() {
		return date;
	}
	public void setDate(MyDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	

}
