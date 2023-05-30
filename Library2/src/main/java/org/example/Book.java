package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String id;
    private String name;
    private String author;
    private String edition;
    private String publisher;
    private String year;
    private String category;
    private ArrayList<Book> all_books = new ArrayList<>();
    private ArrayList<String> all_ids = new ArrayList<>();
    private ArrayList<String> all_names = new ArrayList<>();
    private ArrayList<String> all_authors = new ArrayList<>();
    private ArrayList<String> all_editions = new ArrayList<>();
    private ArrayList<String> all_publishers = new ArrayList<>();
    private ArrayList<String> all_years = new ArrayList<>();
    private ArrayList<String> all_categories = new ArrayList<>();

    public Book(String id, String name, String author, String edition, String publisher, String year, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.publisher = publisher;
        this.year = year;
        this.category = category;
    }
    void read_data() throws FileNotFoundException {
        String line = "";
        FileReader fileReader = new FileReader("Books.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(line);
        }
    }
}
