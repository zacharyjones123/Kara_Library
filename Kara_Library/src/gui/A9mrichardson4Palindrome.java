package gui;

/* A9mrichardson4Palindrome
 * Morgan Richardson
 * Use java code to create a system that checks if statements are palindromes
 * 
 * Prepare: I am going to need to import a scanner to get user input from the keyboard, and I
 * also am going to need to use a String method for the user to import their sentence/words.
 * This will also need to be able to import multiple strings from the user until they say to stop.
 * Then, the code will check to see if it's indeed a palindrome.
 * Input: Get user's input as a String until they say to stop
 * Process: 
 * Output: Output a println() that will specify if the user's input is a palindrome
 */

import java.util.Scanner;
class A9mrichardson4Palindrome {

	public static void isPalindrome(String userInput) {
		String userInputChecked= userInput.replaceAll("[\\W]", "");
		userInputChecked.equalsIgnoreCase(userInput);
		String check = new StringBuffer(userInputChecked).reverse().toString().toLowerCase();

		if (userInputChecked.toLowerCase().equals(check)) {

			System.out.println("This is a palindrome!");
		} else {
			System.out.println("This is not a palindrome.");
		}
	}



	public static void main (String [] args) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter("");

		System.out.println("Today, we will be testing words or sentences to see if they are palindromes.");
		System.out.println("Enter a word or sentence to see if it is a palindrome.");

		String userInput = keyboard.next("[A-Za-z]+");
		isPalindrome(userInput);

	}
}