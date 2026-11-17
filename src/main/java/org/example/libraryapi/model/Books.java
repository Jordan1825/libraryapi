package org.example.libraryapi.model;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() { return bookList; }
    public void setBookList(List<Book> bookList) { this.bookList = bookList; }

}
