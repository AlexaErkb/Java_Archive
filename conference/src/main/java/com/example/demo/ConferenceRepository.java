package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    @Query("SELECT p FROM Conference p WHERE CONCAT(p.name, ' ', p.date_of_issue, ' ', p.name_of_moderator,' ', p.name_of_spiker) LIKE %?1%")
    List<Conference> search(String keyword);
}
