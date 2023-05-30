package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;


@Entity
public class Car {
    private Long id;
    private String mark;
    private Integer date_of_issue;
    private String name_of_owner;
    private java.sql.Date date_of_delivery;

    protected Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(Integer date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getName_of_owner() {
        return name_of_owner;
    }

    public void setName_of_owner(String name_of_owner) {
        this.name_of_owner = name_of_owner;
    }

    public Date getDate_of_delivery() {
        return date_of_delivery;
    }

    public void setDate_of_delivery(Date date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }
}
