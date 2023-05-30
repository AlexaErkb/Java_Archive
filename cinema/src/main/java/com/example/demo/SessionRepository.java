package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Sesion, Long> {
    @Query("SELECT p FROM Sesion p WHERE CONCAT(p.name, ' ',p.studio, ' ', p.date_of_issue, ' ', p.ticker) LIKE %?1%")
    List<Sesion> search(String keyword);
}
