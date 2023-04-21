package com.example.emtsb.repository;

import com.example.emtsb.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    void deleteByName(String name);

}
