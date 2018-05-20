package Advent_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advent_10 {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/Advent_10/input10.txt"));
		
		int[] list = new int[256];
		int skipSize = 0;
		int currPos = 0;
		int length = sc.nextInt();
		
		//fill the array
		for(int i = 0; i <= 255; i++) {
			list[i] = i;
		}
		
		while(sc.hasNext()) {
			System.out.println("Curr Pos: " + currPos);
			System.out.println("SkipSize: " + skipSize);
			System.out.println("Length: " + length);
		
			printOutList(list);
			printOutCurrPos(list, currPos);
			printOutCurrInterval(list, currPos, length+skipSize);
			list = intervalReversed(list, currPos, length+skipSize);
			printOutList(list);
		
			//increase skipsize
			currPos += length+skipSize;
			while(currPos > list.length -1) {
    			currPos -= list.length;
    			System.out.println("New CurrPos: " + currPos);
    		}

			skipSize++;
			length = sc.nextInt();
		}
		
		
		
	}
	
	public static void printOutList(int[] list) {
		for(int i = 0; i <= 255; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	public static void printOutCurrPos(int[] list, int currPos) {
		for(int i = 0; i <= 255; i++) {
			if(i != currPos) {
				System.out.print(list[i] + " ");
			} else {
				System.out.print("(" + list[i] + ")" + " ");
			}
		}
		System.out.println();
	}
	
	public static void printOutCurrInterval(int[] list, int currPos, int length) {
		for(int i = 0; i <= 255; i++) {
			if(i == currPos) {
				System.out.print("([" + list[i] + "]");
			} else if( i == (currPos+length-1)) {
				System.out.print(list[i] + ") ");
			} else {
				System.out.print(list[i] + " ");
			}
		}
		System.out.println();
	}
	
	public static int[] intervalReversed(int[] list, int currPos, int length) {
		boolean hitCurrPos = false;
		for(int i = 0; i <= 255; i++) {
			
			//Need to reverse
			if(i >= currPos && i < currPos+length) {
				int endPos = 0;
				if(!hitCurrPos) {
					//Reverse the elements
					if((currPos + length) > list.length - 1) {
            			endPos = (currPos + length) - list.length;
            		} else {
            			endPos = currPos+length;
            		}
					reverse(list, currPos, endPos);
					hitCurrPos = true;
				}
			}
		}
		System.out.println();
		return list;
	}
	
	//Code from https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
	// Function to reverse every sub-array formed by
    // consecutive k elements
    static void reverse(int arr[], int currPos, int endPos)
    {
            int temp;
            int left = currPos;
            int right = endPos;
            
            System.out.println(currPos + " " + endPos);
            if(right > arr.length-1) {
            	System.out.println("djfiasdjlfksdjaf");
            	right -= arr.length;
            }
            
            //2 cases here
            //1, where left is < right
            if(left < right) {
             
            	// reverse the sub-array [left, right]
            	while (left < right)
            	{
            		temp=arr[left];
            		arr[left]=arr[right];
            		arr[right]=temp;
            		if((left+1) > arr.length - 1) {
            			left = 0;
            		} else {
            			left+=1;
            		}
            		
            		if((right - 1) < 0) {
            			right = arr.length;
            		} else {
            			right-=1;
            		}
            	}
            } else {
            	while (left > right)
            	{
            		temp=arr[left];
            		arr[left]=arr[right];
            		arr[right]=temp;
            		if((left+1) > arr.length - 1) {
            			left = 0;
            		} else {
            			left+=1;
            		}
            		
            		if((right - 1) < 0) {
            			right = arr.length - 1;
            		} else {
            			right-=1;
            		}
            	}
            }
        
    }

}
