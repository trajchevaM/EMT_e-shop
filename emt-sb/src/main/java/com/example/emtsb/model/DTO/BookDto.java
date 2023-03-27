package com.example.emtsb.model.DTO;

import com.example.emtsb.model.ENUM.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookDto {
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    //@ManyToOne - ne se referencira objekt tuku se prakja id
    //Author author;
    Long authorId;
    Integer availableCopies;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
