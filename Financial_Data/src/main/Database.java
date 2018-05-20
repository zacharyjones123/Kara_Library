package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import tools.MyDate;

public class Database {
	
	private ArrayList<Data> data;
	private ArrayList<String> students;
	private ArrayList<Integer> studentsCount;
	
	/**
	 * Default constructor
	 */
	public Database() {
		data = null;
	}
	
	/**
	 * Parameterized constructor
	 * @param data
	 */
	public Database(String fileName) {
		studentsCount = new ArrayList<Integer>();
		fillData(fileName);
		fillNames();

	}
	
	public void fillNames() {
		ArrayList<String> names = new ArrayList<String>();
		for(Data d : data) {
			//Go through and get all of the names
			//And check for duplicates as you go
			
			if(names.size() == 0) {
				names.add(d.getName());
			} else {	
				if(!names.contains(d.getName())) {
					names.add(d.getName());
					studentsCount.set(names.size()-1, studentsCount.get(names.size()-1)+1);
				} else {
					int index = names.indexOf(d.getName());
					if(studentsCount.get(index) == 0) {
						studentsCount.set(index, 1);
					} else {
						studentsCount.set(index, studentsCount.get(index)+1);
					}
				}
			}
			
		}
		//Collections.sort(names, Collections.reverseOrder());
		this.students = names;
	}
	
	public void fillData(String fileName) {
		//Make a new Scanner to read in file
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
			e.printStackTrace();
		}
		//Change the delimiter to commas
		sc.useDelimiter("[ ,\r\n]");

		
		//Now, we read in all of the different parts
		//into a list of objects
		ArrayList<Data> data = new ArrayList<Data>();
		
		//So, read in data from the data file
		while(sc.hasNext()) {
			
			studentsCount.add(0);
			
			String line = sc.nextLine();
			String[] splitter = line.split(",");
			
			try {
				data.add(new Data(splitter[0], splitter[1], splitter[2], splitter[3],splitter[4],splitter[5]));
				Data newData = data.get(data.size()-1);
				double money = Double.parseDouble(splitter[6]);
				newData.setMoney(money);
				data.remove(data.size()-1);
				data.add(newData);
				
			} catch(NumberFormatException f) {
				Data newData = data.get(data.size()-1);
				newData.setMoney(0.0);
				data.remove(data.size()-1);
				data.add(newData);
			}
		}
		
		this.data = data;
	}
	
	public ArrayList<String> getNamesOfStudents() {	
		return students;
	}
	
	public ArrayList<Integer> getCountsOfStudents() {
		return studentsCount;
	}
	
	/**
	 * Returns the number of likes
	 * @return likes
	 */
	public int getLikes() {
		int likes = 0;
		
		for(Data d : data) {
			//Checks to see if it is a yes
			if(d.getRating().toLowerCase().equals("yes")) {
				likes++;
			}
		}
		
		return likes;
	}
	
	/**
	 * Returns the number of dislikes
	 * @return dislikes
	 */
	public int getDislikes() {
		int dislikes = 0;
		
		for(Data d : data) {
			//Checks to see if it is a dislike
			if(d.getRating().toLowerCase().equals("no")) {
				dislikes++;
			}
		}
		
		return dislikes;
	}
	
	/**
	 * Returns the number of lessons
	 * @return number of lessons
	 */
	public int numOfLessons() {
		return data.size();
	}
	
	/**
	 * Returns number of working days
	 * @return working days
	 */
	public int numOfWorkingDays() {
		int numOfWorkingDays = 0;
		
		//TODO: Complete numOfWorkingDays
		
		return numOfWorkingDays;
	}
	
	/**
	 * Returns number of non-working days
	 * @return non-working days
	 */
	public int numOfNonWorkingDays() {
		int numOfNonWorkingDays = 0;
		
		//TODO: Complete numOfNonWorkingDays
		
		return numOfNonWorkingDays;
	}
	
	/**
	 * Returns number of different people
	 * @return num of diff people
	 */
	public int numOfDifferentPeople() {
		int numOfDiffPeople = 0;
		
		//TODO: numOfDifferentPeople
		
		return numOfDiffPeople;
	}
	
	/**
	 * Returns a sorted list of the most popular
	 * people
	 * @return popular people
	 */
	public ArrayList<Data> listOfPopularPeople() {
		ArrayList<Data> popular = new ArrayList<Data>();
		
		//TODO: Complete listOfPopularPeople
		
		return popular;
	}
	
	/**
	 * Returns the start of the data set
	 * @return start day of set
	 */
	public String startOfData() {
		String data = "";
		
		//TODO: Complete startOfData()
		
		return data;
	}
	
	/**
	 * Returns the end of the data set
	 * @return Last day of set
	 */
	public String endOfData() {
		String data = "";
		
		//TODO: Complete endOfData
		
		return data;
	}
	
	/**
	 * This will return the grandtotal of all of the data
	 * that is given.
	 * @return
	 */
	public double grandTotal() {
		double totalMoney = 0;
		for(Data d : data) {
			//System.out.println(d.getMoney());
			totalMoney += d.getMoney();
		}
		
		return totalMoney;
	}
	
	/**
	 * This method will return the amount of earnings that were
	 * returned from one day of working.
	 * @param day
	 * @return
	 */
	public double dayEarnings(String day) {
		double dayEarnings = 0.0;
		
		MyDate day1 = new MyDate(day);
		
		for(Data d : data) {
			if(d.getDate().equals(day1)) {
				dayEarnings += d.getMoney();
			}
		}
		
		
		return dayEarnings;
	}
	
	/**
	 * 
	 * This method will return the amount of earnings that were returned
	 * from one day to another day
	 * @param start
	 * @param end
	 * @return
	 */
	public double intervalEarnings(String start, String end ) {
		double intEarnings = 0.0;
		
		MyDate startDate = new MyDate(start);
		MyDate endDate = new MyDate(end);
		
		for(Data d : data) {
			if(d.getDate().lessThan(endDate) && d.getDate().greaterThan(startDate)) {
				intEarnings+=d.getMoney();
			}
		}
		
		return intEarnings;
	}
	
	/**
	 * Return number of written lessons
	 * @return number of written lessons
	 */
	public int numOfWrittenLessons() {
		int numOfWritten = 0;
		
		for(Data d : data) {
			if(d.getType().toLowerCase().contains("written")) {
				numOfWritten++;
			}
		}
		
		return numOfWritten;
	}
	
	/**
	 * Return number of live lessons
	 * @return number of live lessons
	 */
	public int numOfLiveLessons() {
		int numOfLive = 0;
		
		for(Data d : data) {
			if(d.getType().toLowerCase().contains("live")) {
				numOfLive++;
			}
		}
		
		return numOfLive;
	}
	
}
