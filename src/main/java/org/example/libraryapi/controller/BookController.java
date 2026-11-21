package org.example.libraryapi.controller;

import org.example.libraryapi.dao.BookDAO;
import org.example.libraryapi.model.Book;
import org.example.libraryapi.model.Books;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public Books getBooks(){
        return bookDAO.getAllBooks();
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {
        Book book = bookDAO.getBookByIsbn(isbn);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);

    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookDAO.addBook(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{isbn}")
                .buildAndExpand(book.getIsbn())
                .toUri();
        return ResponseEntity.created(location).body(book);

    }
}
