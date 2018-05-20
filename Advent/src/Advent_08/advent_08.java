package Advent_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class advent_08 {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/Advent_08/input08.txt"));
		ArrayList<String> registers;
		ArrayList<Integer> registerValues;
		ArrayList<Integer> maxValues;
		
		
		registers = new ArrayList<String>();
		registerValues = new ArrayList<Integer>();
		maxValues = new ArrayList<Integer>();
		
		while(sc.hasNext()) {
			//First line of input
			String first = sc.next();
			String change = sc.next();
			int changeNum = sc.nextInt();
			sc.next(); //if
			String second = sc.next();
			String symbol = sc.next();
			int symbolNum = sc.nextInt();
		
			//Add b 0 and a 0
			
			int testIndex = registers.indexOf(first);
			if(testIndex == -1) {
				registers.add(first);
				registerValues.add(0);
			}
			
			testIndex = registers.indexOf(second);
			if(testIndex == -1) {
				registers.add(second);
				registerValues.add(0);
			}
		
			//Now, need to check to see what happens
			boolean soln = checkCondition(second, symbol, symbolNum, registers, registerValues);
		
			if(soln) {
				int index = registers.indexOf(first);
				int value = registerValues.get(index);
			
				if(change.equals("inc")) {
					registerValues.set(index, value + changeNum);
				} else {
					registerValues.set(index, value - changeNum);
				}
			}
			
			maxValues.add(Collections.max(registerValues));
		}
		
		System.out.println(Collections.max(maxValues));
		
		
		
	}
	
	public static boolean checkCondition(String second, String symbol, int symbolNum, ArrayList<String> registers, ArrayList<Integer> registerValues) {
		boolean cond = false;
		
		//Need a case for each one of the inequalities
		
		// 1) Need to find the actual value of the symbol
		int index = registers.indexOf(second);
		int value = registerValues.get(index);
		
		//the test below is with value and symbolNum
		
		if(symbol.equals("<")) {
			if(value < symbolNum) {
				cond = true;
			}
			
		}else if(symbol.equals("<=")) {
			if(value <= symbolNum) {
				cond = true;
			}
			
		}else if(symbol.equals(">")) {
			if(value > symbolNum) {
				cond = true;
			}
			
		}else if(symbol.equals(">=")) {
			if(value >= symbolNum) {
				cond = true;
			}
			
		} else if(symbol.equals("==")) {
			if(value == symbolNum) {
				cond = true;
			}
			
		} else if(symbol.equals("!=")) {
			if(value != symbolNum) {
				cond = true;
			}
			
		} else {
			System.out.println("Error in the code");
			System.exit(1);
		}
		
		return cond;
	}

}
