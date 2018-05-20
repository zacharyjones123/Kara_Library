package Advent_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class advent_06 {
	
	public static void main(String args[]) throws FileNotFoundException {
	
	Scanner sc = new Scanner(new File("src/advent_06/input6.txt"));
	
	//Need to take everything from the scanner and put them in an array
	ArrayList<Integer> ar = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> identity = new ArrayList<ArrayList<Integer>>();
	
	
	//Make the array and fill it with a scanner
	while(sc.hasNext()) {
		int x = sc.nextInt();
		ar.add(x);
	}
	
	//Now fill the identity array
	
	
	int count = 0;
	
	
	ArrayList<Integer> lastAdded = null;
	//This will loop over and over again until ar is identicical to identity
	while(!findEquals(ar, identity, count)) {

		if(lastAdded != null) {
			identity.add(lastAdded);
			//System.out.println("This is LastAdded");
			for(Integer i = 0; i < lastAdded.size(); i++) {
				//System.out.print(lastAdded.get(i) + " ");
			}
		}
		count++;
		//Find the highest one
		int maxNum = Collections.max(ar);
		//Have the index of the max
		int index = ar.indexOf(maxNum);
		//To change the index, redo
		int redo = ar.indexOf(maxNum);
		lastAdded = new ArrayList<Integer>();
		
		for(int i = 0; i < ar.size(); i++) {
			lastAdded.add(ar.get(i));
		}
		
		
		
		//Redistribution
		for(int i = 0; i < maxNum; i++) {
			//Take the index and add 1
			if(index == (ar.size()-1)) {
				index = 0;
			} else {
				index++;
			}
			
			int currentValue = ar.get(index);
			ar.set(index, currentValue+1);
		}
		//subtract the max from the index of the correct number
		int currentValue = ar.get(redo);
		ar.set(redo, currentValue-maxNum);
		
		
		//System.out.println("---------------");
		//System.out.println("This is AR");
		for(Integer i = 0; i < ar.size(); i++) {
			//System.out.print(ar.get(i) + " ");
		}
		//System.out.println();
	
	}
	System.out.println(count);
	}
	
	public static boolean findEquals(ArrayList<Integer> ar, ArrayList<ArrayList<Integer>> identity, int count) {
		/**
		System.out.println("The contents of Identity are: ");
		for(ArrayList<Integer> k : identity) {
			for(Integer l : k) {
				System.out.println(l + " ");
			}
			System.out.println();
		}
		System.out.println("End of Identity");
		**/
		boolean isEquals = true;
		boolean reallyEquals = false;
		
		if(count == 0) {
			return false;
		} else {
		
			for(int j = 0; j < identity.size(); j++) {
				isEquals = true;
				//System.out.println("Home");
				for(int i = 0; i < ar.size(); i++) {
					//System.out.println(j);
					//System.out.println(ar.get(i));
					//System.out.println(identity.get(j).get(i) + "-");
						if(!ar.get(i).equals(identity.get(j).get(i))) {
							
							isEquals = false;
						}
				}
				System.out.println();
				if(isEquals) {
					reallyEquals = true;
				}
			}
		}
		
		return reallyEquals;
	}

}
