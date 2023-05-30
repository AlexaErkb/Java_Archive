package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT p FROM Book p WHERE CONCAT(p.name, ' ', p.publishing_house, ' ', p.date_of_issue, ' ', p.name_of_student, ' ', p.date_of_delivery) LIKE %?1%")
    List<Book> search(String keyword);
}
