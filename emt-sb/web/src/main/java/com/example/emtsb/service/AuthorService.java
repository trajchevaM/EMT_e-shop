package com.example.emtsb.service;

import com.example.emtsb.model.Author;
import com.example.emtsb.model.DTO.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> findById(Long id);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
