package com.example.emtsb.service;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.DTO.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
     Book getBookById(long id);

     List<Book> findAllByCategory(String categoryName);
     List<Book> findAll();
     void add(Book book);

     Optional<Book> findById(Long id);

     Optional<Book> save(BookDto bookDto);

     Optional<Book> edit(Long id, BookDto bookDto);

     void deleteById(Long id);

     Optional<Book> markAsTaken(Long id);

     Page<Book> findAll(Pageable pageable);
}
