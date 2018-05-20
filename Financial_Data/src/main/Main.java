package main;

import java.io.*;
import java.util.*;

import tools.MyDate;

public class Main {
	
	public static void main(String args[] ) {

		
		Database database = new Database("tutor_data.csv");
		
		//Now, print out the total money earned
		
		System.out.println("Grand Total: " + database.grandTotal());
		System.out.println("Num Of Lessons: " + database.numOfLessons());
		System.out.println("Live lessons: " + database.numOfLiveLessons());
		System.out.println("Written lessons: " + database.numOfWrittenLessons());
		System.out.println("NAMES OF ALL OF THE STUDENTS: ");
		for(int i = 0; i < database.getNamesOfStudents().size(); i++) {
			System.out.println(database.getNamesOfStudents().get(i) + " : " + database.getCountsOfStudents().get(i));
		}
		System.out.println("Number Of Students: " + database.getNamesOfStudents().size());
		System.out.println("------------------");
		
		MyDate date = new MyDate("4/26/2017");
		System.out.println("This is the date: " + date);
		System.out.println("I made: " + database.dayEarnings("4/26/2017"));
		System.out.println("Interval test: " + database.intervalEarnings("4/25/2017", "4/27/2017"));
		System.out.println("The start of the data is: " + database.startOfData());
		System.out.println("The end of the data is: " + database.endOfData());

	}

}
