package edu.icet.controller;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book") // now here
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

    //@Autowired
    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {
        service.addBook(book);



    }

    @GetMapping("/get")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Deleted";

    }

    @GetMapping("/search/{id}")
    public Book getBookId(@PathVariable Long id) {
        return service.getBookId(id);
    }
}
