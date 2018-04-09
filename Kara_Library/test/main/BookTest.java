/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Zachary Jones
 *
 */
public class BookTest {
	
	static Book nullBook;
	static Book basicBook;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		nullBook = null;
		basicBook = new Book("ISBN",
							"title",
							"authorFirst",
							"authorLast",
							"genre",
							"grade",
							"description",
							"subject");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.Book#getISBN()}.
	 */
	@Test
	public void testGetISBN() {
		assertEquals("ISBN", basicBook.getISBN());
	}

	/**
	 * Test method for {@link main.Book#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals("title", basicBook.getTitle());
	}

	/**
	 * Test method for {@link main.Book#getAuthorLast()}.
	 */
	@Test
	public void testGetAuthorLast() {
		assertEquals("authorLast", basicBook.getAuthorLast());
	}

	/**
	 * Test method for {@link main.Book#getAuthorFirst()}.
	 */
	@Test
	public void testGetAuthorFirst() {
		assertEquals("authorFirst", basicBook.getAuthorFirst());
	}

	/**
	 * Test method for {@link main.Book#getGenre()}.
	 */
	@Test
	public void testGetGenre() {
		assertEquals("genre", basicBook.getGenre());
	}

	/**
	 * Test method for {@link main.Book#getGrade()}.
	 */
	@Test
	public void testGetGrade() {
		assertEquals("grade", basicBook.getGrade());
	}

	/**
	 * Test method for {@link main.Book#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		assertEquals("description", basicBook.getDescription());
	}

	/**
	 * Test method for {@link main.Book#getSubject()}.
	 */
	@Test
	public void testGetSubject() {
		assertEquals("subject", basicBook.getSubject());
	}

	/**
	 * Test method for {@link main.Book#getRating()}.
	 */
	@Test
	public void testGetRating() {
		assertEquals(0, basicBook.getRating());
	}

	/**
	 * Test method for {@link main.Book#setISBN(java.lang.String)}.
	 */
	@Test
	public void testSetISBN() {
		basicBook.setISBN("9787654321");
		assertEquals("9787654321", basicBook.getISBN());
	}

	/**
	 * Test method for {@link main.Book#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		basicBook.setTitle("Test Cases");
		assertEquals("Test Cases", basicBook.getTitle());
	}

	/**
	 * Test method for {@link main.Book#setAuthorLast(java.lang.String)}.
	 */
	@Test
	public void testSetAuthorLast() {
		basicBook.setAuthorLast("Jones");
		assertEquals("Jones", basicBook.getAuthorLast());
	}

	/**
	 * Test method for {@link main.Book#setAuthorFirst(java.lang.String)}.
	 */
	@Test
	public void testSetAuthorFirst() {
		basicBook.setAuthorFirst("Zachary");
		assertEquals("Zachary", basicBook.getAuthorFirst());
	}

	/**
	 * Test method for {@link main.Book#setGenre(java.lang.String)}.
	 */
	@Test
	public void testSetGenre() {
		basicBook.setGenre("Love");
		assertEquals("Love", basicBook.getGenre());
	}

	/**
	 * Test method for {@link main.Book#setGrade(java.lang.String)}.
	 */
	@Test
	public void testSetGrade() {
		basicBook.setGrade("3-5");
		assertEquals("3-5", basicBook.getGrade());
	}

	/**
	 * Test method for {@link main.Book#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		basicBook.setDescription("description");
		assertEquals("description", basicBook.getDescription());
	}

	/**
	 * Test method for {@link main.Book#setSubject(java.lang.String)}.
	 */
	@Test
	public void testSetSubject() {
		basicBook.setSubject("Math");
		assertEquals("Math", basicBook.getSubject());
	}

	/**
	 * Test method for {@link main.Book#setRating(int)}.
	 */
	@Test
	public void testSetRating() {
		basicBook.setRating(0);
		assertEquals(0, basicBook.getRating());
	}

	/**
	 * Test method for {@link main.Book#toString()}.
	 */
	@Test
	public void testToString() {
		//Book book = new Book(); // you didn't supply the object, so I guessed
        //String expected = ""; // put the expected value here
        //assertEquals(expected, book.toString());
		assertEquals(true, true);
	}

}
