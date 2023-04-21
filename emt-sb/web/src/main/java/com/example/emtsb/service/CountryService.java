package com.example.emtsb.service;

import com.example.emtsb.model.Country;
import com.example.emtsb.model.DTO.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(CountryDto countryDto);

    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);

}
