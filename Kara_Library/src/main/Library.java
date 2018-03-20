package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Student> students;
	
	public Library() throws FileNotFoundException {
		books = new ArrayList<Book>();
		students = new ArrayList<Student>();
		//Read a txt file and add all of the books one at a time
		Scanner in = new Scanner(new File("src/main/isbn.txt"));
		in.useDelimiter("\r\n");
		while(in.hasNext()) {
			books.add(new Book(in.next(),in.next(),in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine()));
		}
		
		in = new Scanner(new File("src/main/students.txt"));
		while(in.hasNext()) {
			students.add(new Student(in.next(), in.next(), in.next()));
		}
		in.close();
		System.out.println(books);
	}
	
	public Library(ArrayList<Book> books, ArrayList<Student> students) {
		this.books = books;
		this.students = students;
	}
	
	//Actions of the library
	
	public void viewBooks() {
		for(Book b : books) {
			System.out.println(b);
		}
	}
	
	public void viewStudents() {
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	
	//Getters
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	//Setters
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
