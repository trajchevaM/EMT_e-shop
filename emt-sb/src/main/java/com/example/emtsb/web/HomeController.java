package com.example.emtsb.web;

import com.example.emtsb.model.Book;
import com.example.emtsb.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class HomeController {
    final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    private List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping("/add")
    public void save(@RequestParam Book book) {
        this.bookService.add(book);
    }



}
