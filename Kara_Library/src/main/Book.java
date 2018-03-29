package main;

public class Book {
	
	private String ISBN;
	private String title;
	private String authorLast;
	private String authorFirst;
	private String genre;
	private String grade;
	private String description;
	private String subject;
	
	public Book() {
		this.ISBN = null;
		this.title = null;
		this.authorLast = null;
		this.authorFirst = null;
		this.genre = null;
		this.grade = null;
		this.description = null;
		this.subject = null;
	}
	
	public Book(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public Book(String ISBN, String title, String authorFirst, String authorLast, String genre, String grade, String description, String subject) {
		this.ISBN = ISBN.replace("\n", "").replace("\r", "");
		this.title = title.replace("\n", "").replace("\r", "");
		this.authorLast = authorLast.replace("\n", "").replace("\r", "");
		this.authorFirst = authorFirst.replace("\n", "").replace("\r", "");
		this.genre = genre.replace("\n", "").replace("\r", "");
		this.grade = grade.replace("\n", "").replace("\r", "");
		this.description = description.replace("\n", "").replace("\r", "");
		this.subject = subject.replace("\n", "").replace("\r", "");
		
		//Ok, and every 10 words, add an enter in the description
		String temp = "";
		String[] splitter = description.split(" ");
		for(int i = 0; i < splitter.length; i++) {
			temp += splitter[i] + " ";
			if(i % 10 == 0 && i != 0) {
				temp += "\n";
			}
		}
		
		this.description = temp;
	}
	
	
	
	//Getters (Accessors)
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthorLast() {
		return authorLast;
	}
	
	public String getAuthorFirst() {
		return authorFirst;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSubject() {
		return subject;
	}
	
	//Setters (Mutators)
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthorLast(String authorLast) {
		this.authorLast = authorLast;
	}
	
	public void setAuthorFirst(String authorFirst) {
		this.authorFirst = authorFirst;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		String s = "";
		s += ISBN + "\n";
		s += title + "\n";
		s += authorFirst + "\n";
		s += authorLast + "\n";
		s += genre + "\n";
		s += grade + "\n";
		s += subject + "\n";
		String text = description;
		text = text.replace("\n", "").replace("\r", "");
		s += text;
		return s;
	}

}
