package com.example.emtsb.service.impl;

import com.example.emtsb.model.Author;
import com.example.emtsb.model.Country;
import com.example.emtsb.model.DTO.AuthorDto;
import com.example.emtsb.repository.AuthorRepository;
import com.example.emtsb.repository.CountryRepository;
import com.example.emtsb.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow();
        //kreiraj iskluchok

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        //kreiraj iskluchoci

        Author author = this.authorRepository.findById(id)
                .orElseThrow();

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());

        Country country = this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow();
        author.setCountry(country);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
