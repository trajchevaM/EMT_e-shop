package com.example.emtsb.web;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.ENUM.Category;
import com.example.emtsb.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {

    private final BookService bookService;

    public CategoryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Category> findAll(){
        return Arrays.stream(Category.values()).toList();
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Book>> findBooksByCategory(@PathVariable String categoryName){
        if(Category.isItACategoryName(categoryName)){
            return ResponseEntity.ok().body(this.bookService.findAllByCategory(categoryName.toUpperCase()));
        }
        return ResponseEntity.badRequest().build();
    }

}
