package Advent_03;

import java.io.File;
import java.util.Scanner;

public class advent_03 {
	
	public static void main(String args[]) {
		
		System.out.println("First we need to figure out what square we are in:");
		
		double answer = 1;
		int square = 1;
		
		while(answer <= 361527 ) {
			answer += (8 * square);
			square++;
		}
		
		System.out.println("----So we are in square 301, starting with 361201 at the bottom left");
		
		System.out.println("Now, we also know how many elements are in square 301, each square goes such that:");
		System.out.println("Square 1, 1\n, Square 2, 8\n Square 3: 16\n Square 4: 24,\n Square 5:  48,\n Square 6:  80,\n Square 7: 120,.....");
		
		answer = 1;
		for(int i = 1; i < 301; i++) {
			answer += (8 * i);
		}
		System.out.println(answer);
		System.out.println("So there are 361201 elements in that box, so, all we need to do, is go north: " + (527 - 201) + " spaces.");
	}

}
