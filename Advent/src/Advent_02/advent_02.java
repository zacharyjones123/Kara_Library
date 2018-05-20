package Advent_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advent_02 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/advent_02/input1.txt"));
		int answer = 0;
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			System.out.println(input);
			String[] tokens = input.split("\t");
			int length = tokens.length;
			
			boolean divis = false;
			
			for(int i = 0; i <= length-1; i++) {
				int currNum = Integer.parseInt(tokens[i]);
				for(int j = 0; j <= length-1; j++) {
					if(j != i) {
						int otherNum = Integer.parseInt(tokens[j]);
						if(otherNum <= currNum && currNum % otherNum == 0 ) {
							System.out.println("Hello person: " + (currNum));
							answer += (currNum / otherNum);
						}
					}
				}
			}
		}
		
		System.out.println(answer);

	}

}
