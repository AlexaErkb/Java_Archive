package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;


@Entity
public class Conference {
    private Long id; // ID

    private String name; // Фамилия
     // номер студенческого
    private java.sql.Date date_of_issue; // номер студенческого
    private String name_of_moderator; // средний балл
    private String name_of_spiker;


    protected Conference() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(Date date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getName_of_moderator() {
        return name_of_moderator;
    }

    public void setName_of_moderator(String name_of_moderator) {
        this.name_of_moderator = name_of_moderator;
    }

    public String getName_of_spiker() {
        return name_of_spiker;
    }

    public void setName_of_spiker(String name_of_spiker) {
        this.name_of_spiker = name_of_spiker;
    }
}
