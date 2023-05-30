package org.example;

import java.util.Date;

public class Product {
    public String name;
    public Date date;
    public Product(String name, Date date) {
        this.name = name;
        this.date = date;
    }
    public String getName() {return name;}
    public Date getDate() {return date;}
}
