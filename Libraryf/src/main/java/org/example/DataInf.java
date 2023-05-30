package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.example.Book;

public class DataInf {
    public ArrayList<Book> allinf = new ArrayList<Book>();
    public ArrayList<Book> booksforgiven  = new ArrayList<Book>();
    public ArrayList<Book> booksforUsers  = new ArrayList<Book>();
    public ArrayList<Manager> allMang = new ArrayList<Manager>();
    public ArrayList<Worker> allWork = new ArrayList<Worker>();
    public ArrayList<User> allUser = new ArrayList<User>();
    /*public DataInf() throws Exception {
        readFileBooks();
        readFileManager();
        //readFileWorker();
        //readFileUser();
    }*/
    // вроде оказался не нужен в итоге, но я не уверена так что НЕ удалять
    public String readBooks(String name) throws Exception{
        String line = "";
        FileReader fileReader = new FileReader("books.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();

        }
        fileReader.close();
        return line;
    }
    // заполнение по массивам идет из файла
    public void readFileBooks() throws Exception{
        allinf.clear();
        String line = "";
        FileReader fileReader = new FileReader("books.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");
           // for (int i=0;i<inf.length;i++){
          //      System.out.println(inf[i]);
          //  }
            String id = inf[0];

            String name =inf[1];

            String auth =inf[2];
            String edition =inf[3];
            String publisher =inf[4];
            String year =inf[5];
            String category =inf[6];
            Book book = new Book(id, name, auth, edition, publisher, year, category);
            allinf.add(book);

        }
        fileReader.close();
        readFileBooksGive();
        readFileBooksBack();
    }
    public void readFileBooksGive() throws Exception{
        booksforgiven.clear();
        String line = "";
        FileReader fileReader = new FileReader("booksforgiven.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");
            String id = inf[0];

            String name =inf[1];

            String auth =inf[2];
            String edition =inf[3];
            String publisher =inf[4];
            String year =inf[5];
            String category =inf[6];
            Book book = new Book(id, name, auth, edition, publisher, year, category);

            booksforgiven.add(book);
        }
        fileReader.close();

    }
    public void readFileBooksBack() throws Exception{
        booksforUsers.clear();
        String line = "";
        FileReader fileReader = new FileReader("booksback.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");
            String id = inf[0];
            String name =inf[1];
            String auth =inf[2];
            String edition =inf[3];
            String publisher =inf[4];
            String year =inf[5];
            String category =inf[6];
            Book book = new Book(id, name, auth, edition, publisher, year, category);
            booksforUsers.add(book);
        }
        fileReader.close();

    }
    public void readFileManager() throws Exception{
        /*String line = "0,Анна,Дубова,Ивановна,ул.Никитина дом 5 кв 6";
        String[] inf = line.split(",");


        String id = inf[0];
        String name =inf[1];
        String surname =inf[2];
        String middle =inf[3];
        String address =inf[4];
        Manager manager = new Manager(id, name, surname, middle, address);
        allMang.add(manager);*/
        String line = "";
        FileReader fileReader = new FileReader("manager.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");


            String id = inf[0];
            String name =inf[1];
            String surname =inf[2];
            String middle =inf[3];
            String address =inf[4];


            Manager manager = new Manager(id, name, surname, middle, address);
            allMang.add(manager);
        }
        fileReader.close();

    }

    public void readFileWorker() throws Exception{
        String line = "";
        FileReader fileReader = new FileReader("worker.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");
            String id = inf[0];
            String name =inf[1];
            String surname =inf[2];
            String middle =inf[3];
            String address =inf[4];

            Worker worker = new Worker(id, name, surname, middle, address);
            allWork.add(worker);

        }
        fileReader.close();

    }
    public void readFileUser() throws Exception{
        String line = "";
        FileReader fileReader = new FileReader("user.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] inf = line.split(",");


            String id = inf[0];
            String name =inf[1];
            String surname =inf[2];
            String middle =inf[3];
            String address =inf[4];
            String book =inf[5];


            User user = new User(id, name, surname, middle, address, book);
            allUser.add(user);

        }
        fileReader.close();

    }
    /*public String readManager(String name) throws Exception{
        String line = "";
        FileReader fileReader = new FileReader("manager.txt");
        Scanner in = new Scanner(fileReader);
        while (in.hasNextLine()) {
            line = in.nextLine();

        }
        return line;
    }*/


}
