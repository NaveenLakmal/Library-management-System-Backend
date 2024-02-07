package edu.icet.service.impl;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);
        repository.save(entity);

    }

    @Override
    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();

        Iterable<BookEntity> iterable = repository.findAll();
        Iterator<BookEntity> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            BookEntity entity = iterator.next();
            Book book = mapper.map(entity, Book.class);
            list.add(book);
        }
        return list;

    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book getBookId(Long id) {
        Optional<BookEntity> bookEntity = repository.findById(id);
        return mapper.map(bookEntity, Book.class);
    }

}
