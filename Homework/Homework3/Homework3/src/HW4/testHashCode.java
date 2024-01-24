package HW4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class testHashCode {
	@Test
	public void testHashCode() {
	    Book book1 = new Book.Builder("Harry Potter", "123456789")
	            .authorName("JK")
	            .year(2000)
	            .publisher("VSB")
	            .genre(Book.Genre.NON_FICTION)
	            .build();
	    Book book2 = new Book.Builder("Doraemon", "2421214210")
	            .authorName("Fukushima")
	            .year(1999)
	            .publisher("JP")
	            .language("Japan")
	            .build();
	    Book book3 = new Book.Builder("Doraemon", "2421214210")
	    .authorName("Fukushima")
	    .year(1999)
	    .publisher("JP")
	    .language("Japan")
	    .build();
	    
	    Set<Book> setOfBooks = new HashSet<>();
	    assertFalse(setOfBooks.contains(book1));
	    setOfBooks.add(book1);
	    assertTrue(setOfBooks.contains(book1));
	    assertTrue(book1.equals(book2));
	    assertTrue(book2.equals(book3));
	    assertTrue(setOfBooks.contains(book2));


	}
}
