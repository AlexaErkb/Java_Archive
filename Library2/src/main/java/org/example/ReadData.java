package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadData {
    private String filename;
    private static ArrayList<String> all_books = new ArrayList<>();
    public ReadData(String filename) throws FileNotFoundException {
        this.filename = filename;
        ReadData.read_data(filename);
    }
    static void read_data(String filename) throws FileNotFoundException {
        String line = "";
        FileReader fileReader = new FileReader(filename);
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(line);
            all_books.add(line);
        }
    }
    public ArrayList<String> getAll_books() {
        return all_books;
    }
}
