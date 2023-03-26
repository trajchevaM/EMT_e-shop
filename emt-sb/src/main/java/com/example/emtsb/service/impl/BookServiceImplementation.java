package com.example.emtsb.service.impl;

import com.example.emtsb.model.Book;
import com.example.emtsb.repository.BookRepository;
import com.example.emtsb.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {
    private BookRepository bookRepository;

    @Override
    public Book getBookById(long id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }
}
