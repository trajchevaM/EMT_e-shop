package com.example.emtsb.service;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.dto.BookDto;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface BookService {
     Book getBookById(long id);
     List<Book> findAll();
     void add(Book book);

     Optional<Book> findById(Long id);

     Optional<Book> save(BookDto bookDto);
}
