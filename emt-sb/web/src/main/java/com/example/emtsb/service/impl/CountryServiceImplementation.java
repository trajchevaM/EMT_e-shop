package com.example.emtsb.service.impl;

import com.example.emtsb.model.Country;
import com.example.emtsb.model.DTO.CountryDto;
import com.example.emtsb.repository.CountryRepository;
import com.example.emtsb.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        this.countryRepository.deleteByName(countryDto.getName());
        Country country = new Country(countryDto.getName(),countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country = this.countryRepository.findById(id).orElseThrow();
        //kreiraj iskluchoci
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        this.countryRepository.save(country);

        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
