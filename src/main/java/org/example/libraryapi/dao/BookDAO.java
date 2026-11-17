package org.example.libraryapi.dao;

import org.example.libraryapi.model.Book;
import org.example.libraryapi.model.Books;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
    private final Books books = new Books();

    public BookDAO() {
        books.getBookList().add(new Book("9780132350884", "Clean Code", "Robert C. Martin", "Prentice Hall"));
        books.getBookList().add(new Book("9780134685991", "Effective Java", "Joshua Bloch", "Addison-Wesley"));
        books.getBookList().add(new Book("9780135957059", "The Pragmatic Programmer", "David Thomas and Andrew Hunt", "Addison-Wesley"));
        books.getBookList().add(new Book("9781491910771", "Head First Java", "Kathy Sierra and Bert Bates", "O'Reilly Media"));
        books.getBookList().add(new Book("9780201633610", "Design Patterns", "Erich Gamma et al.", "Addison-Wesley"));
        books.getBookList().add(new Book("9780735619678", "Code Complete", "Steve McConnell", "Microsoft Press"));
        books.getBookList().add(new Book("9780134757599", "Refactoring", "Martin Fowler", "Addison-Wesley"));
    }

    public Books getAllBooks() {
        return books;
    }
    public Book getBookByIsbn(String isbn) {
        for (Book book : books.getBookList()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.getBookList().add(book);
    }
}
