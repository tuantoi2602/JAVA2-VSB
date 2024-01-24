package HW4;
import java.util.Objects;

public class BookWithEdition extends Book {
    private final int edition;

    public BookWithEdition(Genre genre, String name, String isbn, String authorName, int year, String publisher, int pages, String language, int edition) {
        super(genre, name, isbn, authorName, year, publisher, pages, language);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        BookWithEdition book = (BookWithEdition) obj;
        return edition == book.edition;
    }

}