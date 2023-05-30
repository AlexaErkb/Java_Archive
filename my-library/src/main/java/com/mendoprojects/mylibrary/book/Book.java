package com.mendoprojects.mylibrary.book;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Book {

    public Book() {
    }

    public Book(String name, String publish, Date issuance, String stdnt_name, Date returning) {
        this.name = name;
        this.publish = publish;
        this.issuance = issuance;
        this.stdnt_name = stdnt_name;
        this.returning = returning;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    private String name;
    @Nonnull
    private String publish;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date issuance;
    private String stdnt_name;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date returning;

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

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Date getIssuance() {
        return issuance;
    }

    public void setIssuance(Date issuance) {
        this.issuance = issuance;
    }

    public String getStdnt_name() {
        return stdnt_name;
    }

    public void setStdnt_name(String stdnt_name) {
        this.stdnt_name = stdnt_name;
    }

    public Date getReturning() {
        return returning;
    }

    public void setReturning(Date returning) {
        this.returning = returning;
    }


}
