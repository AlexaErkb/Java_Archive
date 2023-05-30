package org.example;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Worker extends Person {
    DataInf datainf = new DataInf();


    public Worker(String id, String name, String surname, String middle, String address) throws Exception {
        // наследование атрибутов из родительского класса Person
        super(id, name, surname, middle, address);
        datainf.readFileBooks();

    }
    //ищет книги их тех которые можно отдать читателю
    public String findBook(String name){
        String fBook = "";

        for (Book book: datainf.booksforgiven) {
            if (book.getName().equals(name)){
                fBook = name;
            }

        }

        return fBook;
    }
    // ищем из всех книг
    private String findAllBook(String name){
        String fBook = "";
        for (Book book: datainf.allinf) {
            if (book.getName().equals(name)){
                fBook = name;
            }

        }

        return fBook;
    }
    // записываем в файл книги которые у пользователя и убираем книги из файла где книги которые мы можем отдать
    private void addchangeFile(Book b_add, Integer ids) throws IOException{
        FileWriter nFile = new FileWriter("booksback.txt", true);

        BufferedWriter bufferWriter = new BufferedWriter(nFile);

        String newLine = String.format("%s,%s,%s,%s,%s,%s,%s", b_add.getId(), b_add.getName(), b_add.getAuth(), b_add.getEdition(), b_add.getPublisher(), b_add.getYear(), b_add.getCategory());

        bufferWriter.write(newLine);
        bufferWriter.close();


        Integer count = 0;
        String line;
        File sourceFile = new File("booksforgiven.txt");
        File outputFile = new File("booksforgiven2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!(count==ids)){
                writer.write(line);
                writer.newLine();
            }
            count++;
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);


    }
    // Изменяем файл
    private void getchangeFile(Book b_add, Integer ids, Integer idss) throws IOException{
        FileWriter nFile = new FileWriter("booksforgiven.txt", true);

        BufferedWriter bufferWriter = new BufferedWriter(nFile);

        String newLine2 = String.format("%s,%s,%s,%s,%s,%s,%s", b_add.getId(), b_add.getName(), b_add.getAuth(), b_add.getEdition(), b_add.getPublisher(), b_add.getYear(), b_add.getCategory());

        bufferWriter.write(newLine2);
        bufferWriter.close();
       /* String newLine2 = String.format("%s,%s,%s,%s,%s,%s,%s", b_add.getId(), b_add.getName(), b_add.getAuth(), b_add.getEdition(), b_add.getPublisher(), b_add.getYear(), b_add.getCategory());

        System.out.println(ids);
        Integer count2 = 0;
        String line2;
        File sourceFile2 = new File("booksforgiven.txt");
        File outputFile2 = new File("booksforgiven2.txt");
        BufferedReader reader2 = new BufferedReader(new FileReader(sourceFile2));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputFile2));
        while ((line2 = reader2.readLine()) != null) {
            if (!(count2==ids)){
                writer2.write(line2);
                writer2.newLine();
            }
            else {
                writer2.write(newLine2);
                writer2.newLine();

            }
            count2++;
        }
        reader2.close();
        writer2.close();
        sourceFile2.delete();
        outputFile2.renameTo(sourceFile2);*/



        Integer count = 0;
        String line;

        File sourceFile = new File("booksback.txt");
        File outputFile = new File("booksback2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!(count==idss)){
                writer.write(line);
                writer.newLine();
            }
            count++;
        }
        //Удаляем и переименовываем промежуточные файлы
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);


    }
    // пытаемсся получить книгу от пользователя
    public boolean getBook(String nameB) {
        Boolean existBook = true;
        String fBookAll = findAllBook(nameB);
        if (fBookAll.equals("")) {
            existBook = false;
            System.out.println("Такой книги нет в библиотеке, кажется, вы принесли не ту.");
        } else {
            for (Book book: datainf.allinf) {
                if (book.getName().equals(nameB)){
                    int data_bacck =  datainf.booksforUsers.indexOf(book);
                    datainf.booksforUsers.remove(book);
                    datainf.booksforgiven.add(Integer.valueOf(book.getId()), book);
                    try {
                        getchangeFile(book, Integer.valueOf(book.getId()), data_bacck+1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
        try {
            datainf.readFileBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return existBook;
    }
    // пытаемся отдать книгу читателю
    public boolean giveBook(String nameB){
        Boolean existBook = true;
        String fBookAll = findAllBook(nameB);
        if (fBookAll.equals("")) {
            existBook = false;
            System.out.println("Такой книги нет в библиотеке");
        } else {
            String fBook = findBook(nameB);
            if (fBook.equals("")){
                existBook = false;
                System.out.println("Такую книгу уже забрали");
            } else {
                Integer indexBook =0;
                Book book_add = null;
                for (Book book: datainf.booksforgiven) {
                    if (book.getName().equals(nameB)){
                        indexBook = Integer.valueOf(book.getId());
                        datainf.booksforUsers.add(book);
                        book_add = book;
                    }

                }
                datainf.booksforgiven.remove(book_add);
                try {
                    addchangeFile(book_add,indexBook);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        try {
            datainf.readFileBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return existBook;

    }



}
