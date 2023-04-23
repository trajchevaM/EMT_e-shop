package com.example.emtsb.service.impl;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.Author;
import com.example.emtsb.model.DTO.BookDto;
import com.example.emtsb.model.ENUM.Category;
import com.example.emtsb.repository.AuthorRepository;
import com.example.emtsb.repository.BookRepository;
import com.example.emtsb.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Book> findAllByCategory(String categoryName) {
        Category category = Category.valueOf(categoryName);
        return this.bookRepository.findAllByCategory(category);
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

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(); //da se dodade exception

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow();
        if(bookDto.getAvailableCopies()<0)
            throw new RuntimeException();

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow();

        int newAvailable = book.getAvailableCopies()-1;
        if(newAvailable<0){
            throw new RuntimeException();
        }


        book.setAvailableCopies(newAvailable);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }


}
