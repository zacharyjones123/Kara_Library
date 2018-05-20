package Advent_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advent_09 {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/Advent_09/input09.txt"));
		
		//Rules
		//1) begin with { ends with }
		//2) Anything inside is seperated by commas
		//3) Garbage is < and ends with >
		//4) If you see an !, skip a character
		
		//Multiple cases
		//1) The beginning
		// Find a {, so we have started a group
		
		String rawInput = sc.next();
		
		//so we want to go through the raw input, and figure out the number of groups
		
		boolean inTrash = false;
		String newString = "";
		int trash = 0;
		System.out.println(rawInput);
		for(int i = 0; i < rawInput.length(); i++) {
			char temp = rawInput.charAt(i);
			
			//Works
			if(temp == '!') {
				i++;
				//This will skip the character
			} else if( temp == '}') {
				if(inTrash) {
					//Then do something
					newString += temp;
					trash++;
				}
				
			} else if(temp == '{') {
				if(inTrash) {
					//Then do something
					newString += temp;
					trash++;
				}
				
			} else if(temp == ',') {
				if(inTrash) {
					//Then do something
					newString += temp;
					trash++;
				}
			} else if (temp == '<') {
				if(!inTrash) {
					inTrash = true;
				} else {
					trash++;
				}
				
			} else if (temp == '>') {
				if(inTrash) {
					inTrash = false;
				} else {
					trash++;
				}
				
			} else {
				//Ignore all other characters
				if(inTrash) {
					trash++;
				}
			}
			
		}
		
		System.out.println("---------------------------");
		System.out.println(trash);
		
		int numOfGroups = rawInput.length() - newString.replace(" ", "").length();
		int numOfGroups2 = newString.length();
		System.out.println(newString);
		System.out.println(numOfGroups + " " + numOfGroups2);
		
		//So there are 1008 groups total
		
		int score = 0;
		int groupNum = 0;
		for(int i = 0; i < newString.length(); i++) {
			int temp = newString.charAt(i);
			
			if( temp == '}') {
				//close group, add to the score
				//See if we should go up or not
						score += groupNum--;
				
			} else if(temp == '{') {
				//Starts a new group, new layer
						++groupNum;
				
			} else {
			}
			
		}
		
		System.out.println(score);
		
	}

}
