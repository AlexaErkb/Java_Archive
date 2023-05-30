package org.example;

import java.util.ArrayList;

public class Book {
    private String id;
    private String name;
    private String auth;
    private String edition;
    private String publisher;
    private String year;
    private String category;
    ArrayList<Integer> bId = new ArrayList<>();
    ArrayList<String> bName = new ArrayList<>();
    ArrayList<String> bAuth = new ArrayList<>();
    ArrayList<String> bEdition = new ArrayList<>();
    ArrayList<String> bPublisher = new ArrayList<>();
    ArrayList<String> bYear = new ArrayList<>();
    ArrayList<String> bCategory = new ArrayList<>();



    public Book(){

    }
    public Book(String id, String name, String auth, String edition, String publisher, String year, String category){
        //Загружаем данные и проверяем
        if (bId.contains(id)){
            this.id = Integer.toString(bId.get(bId.size()-1)+1);
            bId.add(bId.get(bId.size()-1)+1);
        } else {
            this.id = id;
            bId.add(Integer.valueOf(id));
        }

        this.name = name;

        this.auth = auth;
        this.edition = edition;
        this.publisher = publisher;
        this.year=year;
        this.category = category;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getAuth() {
        return auth;
    }

    public String getCategory() {
        return category;
    }


    public String getYear() {
        return year;
    }

    public String getEdition() {
        return edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
