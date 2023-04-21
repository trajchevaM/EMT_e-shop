package com.example.emtsb.repository;

import com.example.emtsb.model.Book;
import com.example.emtsb.model.ENUM.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    void deleteByName(String name);

    Page<Book> findAll(Pageable pageable);
    List<Book> findAllByCategory(Category category);
}
