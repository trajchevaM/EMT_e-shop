package com.example.emtsb.model;

import jakarta.persistence.*;

import java.util.List;

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;
    @OneToMany
    private List<Author> authors;
}
