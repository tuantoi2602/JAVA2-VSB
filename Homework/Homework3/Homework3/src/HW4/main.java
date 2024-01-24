package HW4;

public class main {
	public static void main(String[] args) {
		
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
	    BookWithEdition bookWithEdition1 = new BookWithEdition(Book.Genre.CODE, "HTML", "21313213", "LLLL", 2005, "VSB", 500, "English", 1);
	    BookWithEdition bookWithEdition2 = new BookWithEdition(Book.Genre.HISTORY,"Game", "123213312", "Phe Game", 2023, "VSB", 100, "Vietnam", 1);
	    BookWithEdition bookWithEdition3 = new BookWithEdition(Book.Genre.CODE, "HTML", "21313213", "LLLL", 2005, "VSB", 500, "English", 1);

	    System.out.println("book1 equals book2: " + book1.equals(book2));
	    System.out.println("book2 equals book3: " + book2.equals(book3));
	    System.out.println("bookWithEdition1 equals bookWithEdition2: " + bookWithEdition1.equals(bookWithEdition2));
	    System.out.println("bookWithEdition1 equals bookWithEdition3: " + bookWithEdition1.equals(bookWithEdition3));

	    int hashCode1 = book1.hashCode();
	    int hashCode2 = book2.hashCode();
	    int hashCode3 = book3.hashCode();

	    System.out.println("book1 hashCode: " + book1.hashCode());
        System.out.println("book2 hashCode: " + book2.hashCode());
        System.out.println("book3 hashCode: " + book3.hashCode());
        
	}

}
