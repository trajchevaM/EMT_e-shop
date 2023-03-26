package com.example.emtsb.model;

import com.example.emtsb.model.ENUM.Category;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Author author;
    Integer availableCopies;


}
