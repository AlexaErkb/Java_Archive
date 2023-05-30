package org.example;

public class Person {
    private String id;
    private String name;
    private String surname;
    private String middle;
    private String address;

    public Person(String id, String name, String surname, String middle, String address){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middle = middle;
        this.address = address;


    }

    public String getAddress() {
        return address;
    }



    public String getName() {
        return name;
    }

    public String getMiddle() {
        return middle;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

