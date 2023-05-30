package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> books;
    public static void main(String[] args) throws Exception {
        ReadData reader = new ReadData("Books.txt");
        books = reader.getAll_books();
        System.out.println(books);
    }
}
