package tools;

public class Person {
	
	String name;
	int lessons;
	
	public Person(String name, int lessons) {
		this.name = name;
		this.lessons = lessons;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLessons() {
		return lessons;
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", lessons=" + lessons + "]";
	}
	
	
	
	

}
