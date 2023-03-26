package com.example.emtsb.service;

import com.example.emtsb.model.Book;

import java.util.List;

public interface BookService {
     Book getBookById(long id);
     List<Book> findAll();
     void add(Book book);
}
