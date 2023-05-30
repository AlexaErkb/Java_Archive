package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT p FROM Car p WHERE CONCAT(p.mark, ' ', p.date_of_issue, ' ', p.name_of_owner, ' ', p.date_of_delivery) LIKE %?1%")
    List<Car> search(String keyword);
}
