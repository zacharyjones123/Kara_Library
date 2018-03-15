package main;

import java.util.Scanner;

/**
 * This is the driver (main method) part of the project.
 * 
 * When you run this you will be prompted by a text display and then
 * be given a bunch of different options of what you can do.
 * 
 * Options:
 * Note: Implementing options currently
 * @author Zachary R. Jones
 *
 */

public class Driver {

	public static void main(String[] args) {
		//Print out a hello message
		
		System.out.println("Hello Kara\nWelcome to Your Library");
		System.out.println("What would you like to do with your library?");
		System.out.println("(1) View All Books");
		System.out.println("(2) Add a New Book");
		System.out.println("(3) View Current Students");
		System.out.print("Type Number: ");
		
		//Now, Kara will be prompted to see different criteria about her library
		Scanner in = new Scanner(System.in);
		int response = in.nextInt();
		
		switch(response) {
		
			case 1 : 
				//View All Books currently available
				break;
			case 2:
				//Add a new book to the list
				break;
			case 3:
				//View all of the current students
				break;
			default: 
				System.out.println("Please Enter A Valid Number");
				break;
		}
		
		System.out.println("Thank you for using Kara's Library.");
		System.out.println("Hope you have a great rest of the day.");
		
		
		
		

	}

}
