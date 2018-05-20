package Advent_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class advent_04 {
	
	public static void main(String args[]) throws FileNotFoundException {
				Scanner sc = new Scanner(new File("src/advent_04/input4.txt"));
				int answer = 0;
				
				while(sc.hasNext()) {
					String input = sc.nextLine();
					String[] tokens = input.split(" ");
					int length = tokens.length;
					
					boolean equalNow = false;
					
					for(int i = 0; i <= length-1; i++) {
						String currString = tokens[i];
						char tempArray[] = currString.toCharArray();
						Arrays.sort(tempArray);
						currString = new String(tempArray);
						for(int j = 0; j <= length-1; j++) {
							
							if(j != i) {
								String otherString = tokens[j];
								char otherArray[] = otherString.toCharArray();
								Arrays.sort(otherArray);
								otherString = new String(otherArray);
								//Need to use charAt to figure out the 
								//We need to create the otherIntTest
								if(currString.equals(otherString)) {
									equalNow = true;
								}
							}
						}
					}
					
					
					if(!equalNow ) {
						System.out.println(input);
						answer++;
						
					}
				}
				
				System.out.println(answer);
	}

}
