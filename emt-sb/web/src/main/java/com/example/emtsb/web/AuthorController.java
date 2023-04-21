package com.example.emtsb.web;

import com.example.emtsb.model.Author;
import com.example.emtsb.model.DTO.AuthorDto;
import com.example.emtsb.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto) {
        return this.authorService.save(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Author> edit(@PathVariable Long id,
                                       @RequestBody AuthorDto authorDto) {
        return this.authorService.edit(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        this.authorService.deleteById(id);
        if (this.authorService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}