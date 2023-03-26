package com.example.emtsb.service.impl;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.Author;
import com.example.emtsb.model.dto.BookDto;
import com.example.emtsb.repository.AuthorRepository;
import com.example.emtsb.repository.BookRepository;
import com.example.emtsb.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

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

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow();
        bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }
}
