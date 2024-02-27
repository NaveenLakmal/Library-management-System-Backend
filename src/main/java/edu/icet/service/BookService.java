package edu.icet.service;

import edu.icet.dto.Book;

import java.util.List;

public interface BookService {


     void addBook(Book book);
    List<Book> getBooks();

    boolean deleteBook(Long id);

    Book getBookId(Long id);
}
