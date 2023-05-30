package org.example;

import java.io.*;
import java.util.SimpleTimeZone;

public class User extends Person{
    String book;
    DataInf datainf = new DataInf();
    public User(String id, String name, String surname, String middle, String address, String book) throws Exception {
        // наследование атрибутов из родительского класса Person
        super(id, name, surname, middle, address);
        datainf.readFileWorker();
        datainf.readFileBooks();
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
    // пытаемся отдать книгу
    public void giveForUser(String nameB){
        String[] giveBack;
        if( getBook().equals("-")){
            System.out.println("У вас нет книг, которые можно вернуть");
        } else{
            // Получаем работника, который примет книгу от пользователя
            int randonWorker = (int) ( Math.random()*datainf.allWork.size());
            Worker worker = datainf.allWork.get(randonWorker);
            boolean existBook =worker.getBook(nameB);
            // Проверка существует ли книга в библиотеке
            if (existBook){
                String getLibBook = getBook();
                giveBack = getBook().split(" ");
                if (giveBack.length ==1){
                    setBook("-");
                    try {
                        addbooksUser();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else {
                    getLibBook = getLibBook.replace(nameB, "").replaceAll("\\s+", " ").trim();
                    setBook(getLibBook);
                    try {
                        addbooksUser();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                System.out.println("Выберите другую книгу");
            }

        }
    }
    // отдали книгу и получили записываем все в файл
    private void addbooksUser() throws IOException{
        Integer ids = Integer.valueOf(getId());
        Integer count = 0;
        String line;
        String line_new;
        File sourceFile = new File("user.txt");
        File outputFile = new File("user2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!(count==ids)){
                writer.write(line);
                writer.newLine();
            } else{
                // Преобразуем строку для добавления в файл
                line_new = String.format("%s,%s,%s,%s,%s,%s", getId(),getName(),getSurname(), getMiddle(), getAddress(), getBook());
                writer.write(line_new);
                writer.newLine();
            }
            count++;
        }
        reader.close();
        writer.close();
        // Удаляем файл и переименовываем
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }
    // получаем книги
    public void getforUser(String nameB){
        // Получаем работника, который даст книгу
        int randonWorker = (int) ( Math.random()*datainf.allWork.size());
        Worker worker = datainf.allWork.get(randonWorker);
        boolean existBook =worker.giveBook(nameB);
        // Проверка есть ли книга в библиотеке
        if (existBook) {
            if( book.equals("-")){
                System.out.println("Книга была передана");
                setBook(nameB);
                try {
                    addbooksUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            else {
                System.out.println("Книга была передана");
                setBook(book+" "+nameB);
                try {
                    addbooksUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            System.out.println("Выберите другую книгу");
        }
    }
    //Показывает книги который читает пользователь
    public void showMyBook(){
        System.out.println("Книги читателя: "+ getBook());
    }
    // Показывает все книги которые есть в библиотеке
    public void showBooks(){
        for (Book book: datainf.allinf) {
            System.out.println(book.getName());
        }
    }

}
