package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    @Query("SELECT p FROM People p WHERE CONCAT(p.login, ' ', p.pass, ' ', p.sec) LIKE %?1%")
    List<People> search(String keyword);
}