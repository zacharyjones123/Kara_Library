package Advent_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class advent_05 {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/advent_05/input5.txt"));
		
		//Need to take everything from the scanner and put them in an array
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		while(sc.hasNext()) {
			ar.add(sc.nextInt());
		}
		
		//Print everything out
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		
		//Set the first element
		int firstElement = ar.get(0);
		System.out.println("First Element: " + firstElement);
		
		int currentIndex = 0;
		int steps = 0;
		
		while( currentIndex >= 0 && currentIndex < ar.size()) {
			int tempIndex = currentIndex;
			tempIndex += ar.get(tempIndex);
			
			if(ar.get(currentIndex) < 3) {
				ar.set(currentIndex, ar.get(currentIndex)+1);
			} else {
				ar.set(currentIndex, ar.get(currentIndex)-1);
			}
			currentIndex = tempIndex;
			
			steps++;
		}
		
		System.out.println(steps);
		
		
	}

}
