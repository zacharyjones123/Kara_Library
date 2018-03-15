package main;

public class Book {
	
	private String ISBN;
	private String title;
	private String[] authorLast;
	private String[] authorFirst;
	private String[] genre;
	private String[] grade;
	private String description;
	
	public Book() {
		this.ISBN = null;
		this.title = null;
		this.authorLast = null;
		this.authorFirst = null;
		this.genre = null;
		this.grade = null;
		this.description = null;
	}
	
	public Book(String ISBN, String title, String[] authorLast, String[] authorFirst, String[] genre, String[] grade, String description) {
		this.ISBN = ISBN;
		this.title = title;
		this.authorLast = authorLast;
		this.authorFirst = authorFirst;
		this.genre = genre;
		this.grade = grade;
		this.description = description;
	}
	
	
	
	//Getters (Accessors)
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String[] getAuthorLast() {
		return authorLast;
	}
	
	public String[] getAuthorFirst() {
		return authorFirst;
	}
	
	public String[] getGenre() {
		return genre;
	}
	
	public String[] getGrade() {
		return grade;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Setters (Mutators)
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthorLast(String[] authorLast) {
		this.authorLast = authorLast;
	}
	
	public void setAuthorFirst(String[] authorFirst) {
		this.authorFirst = authorFirst;
	}
	
	public void setGenre(String[] genre) {
		this.genre = genre;
	}
	
	public void setGrade(String[] grade) {
		this.grade = grade;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
