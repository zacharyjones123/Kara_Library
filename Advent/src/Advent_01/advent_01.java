package Advent_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advent_01 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/advent_01/input.txt"));
		String input = sc.next();
		int length = input.length();
		int step = length/2;
		
		int answer = 0;
		
		for(int i = 0; i < length-1; i++) {
			int newStep = 0;
			if(i+step >= length) {
				newStep =(i+step) - length;
			} else {
				newStep = i+step;
			}
			if(Character.getNumericValue(input.charAt(i)) == Character.getNumericValue(input.charAt(newStep))) {
				System.out.println(i + ": " + Character.getNumericValue(input.charAt(i)) );
				answer+=Character.getNumericValue(input.charAt(i));
			}
		}
		
		System.out.println(answer);

	}

}
