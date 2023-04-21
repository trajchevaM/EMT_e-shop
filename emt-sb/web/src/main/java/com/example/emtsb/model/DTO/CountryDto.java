package com.example.emtsb.model.DTO;

import lombok.Data;

@Data
public class CountryDto {

    private String name;

    private String continent;

    public CountryDto(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
    public CountryDto() {
    }


}