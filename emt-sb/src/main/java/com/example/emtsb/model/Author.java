package com.example.emtsb.model;

import jakarta.persistence.*;
import java.util.List;


public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    @OneToMany
    private List<Book> books;

}