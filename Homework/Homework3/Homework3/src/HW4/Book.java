package HW4;
import java.util.Objects;

public class Book {
    private final Genre genre;
    private final String name;
    private final String isbn;
    private final String authorName;
    private final int year;
    private final String publisher;
    private final int pages;
    private final String language;

    public Book(Genre genre, String name, String isbn, String authorName, int year, String publisher, int pages, String language) {
        this.genre = genre;
        this.name = name;
        this.isbn = isbn;
        this.authorName = authorName;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
        this.language = language;
    }

    public enum Genre {
        FICTION,
        NON_FICTION,
        THRILLER,
        ROMANCE,
        BIOGRAPHY,
        HISTORY,
        CODE
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return year == book.year &&
                pages == book.pages &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(name, book.name) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(authorName, book.authorName) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(language, book.language);
    }
    
    public static class Builder {
        private Genre genre;
        private String name;
        private String isbn;
        private String authorName;
        private int year;
        private String publisher;
        private int pages;
        private String language;

        public Builder(String name, String isbn) {
            this.name = name;
            this.isbn = isbn;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder authorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Book build() {
            return new Book(genre, name, isbn, authorName, year, publisher, pages, language);
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(genre, name, isbn, authorName, year, publisher, pages, language);
    }
    /*@Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + genre.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + isbn.hashCode();
        result = 31 * result + authorName.hashCode();
        result = 31 * result + year;
        result = 31 * result + publisher.hashCode();
        result = 31 * result + pages;
        result = 31 * result + language.hashCode();
        return result;
    }*/
}
