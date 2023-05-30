package org.example;
import org.example.DataInf;
import org.example.Book;

import java.io.*;

public class Manager extends Person{
    enum categories{
        Фантастика("Фантастика"),
        Классика("Классика");
        private String code;
        categories(String representation) {
            this.code = representation;
        }
        public String getCode() {
            return code;
        }
    }
    DataInf datainf = new DataInf();


        //dtinf.readFileWorker();
        //dtinf.readFileUser();

    public Manager(String id, String name, String surname, String middle, String address) throws Exception {
        // наследование атрибутов из родительского класса Person
        super(id, name, surname, middle, address);
        // Читает файлы
        datainf.readFileBooks();
        datainf.readFileUser();
    }
    // добавляем книгу
    public void addBooks(String id, String name, String auth, String edition, String publisher, String year, String category) throws IOException{

       FileWriter nFile = new FileWriter("books.txt", true);
       FileWriter nFile2 = new FileWriter("booksforgiven.txt", true);
       BufferedWriter bufferWriter = new BufferedWriter(nFile);
       BufferedWriter bufferWriter2 = new BufferedWriter(nFile2);

       for (Book book: datainf.allinf) {
            if (book.getId().equals(id)){
                id = Integer.toString(datainf.allinf.size());
            }

        }

       Book book = new Book(id, name, auth, edition, publisher, year, category);
       datainf.allinf.add(book);
       datainf.booksforgiven.add(book);
       // Добавляем книгу в файл
       String newLine = String.format("\n%s,%s,%s,%s,%s,%s,%s", book.getId(), name, auth, edition, publisher, year, category);
       bufferWriter.write(newLine);
       bufferWriter.close();
       bufferWriter2.write(newLine);
       bufferWriter2.close();
       System.out.println("Книга добавлена");

       //nFile.write(newLine);
      // nFile.close();

    }
    //Удаляем книгу из библиотеки
    public void deleteBook(String id) throws IOException{
        boolean exBook = false;
        Integer ids = 0;
        Book book_de = null;
        for (Book book: datainf.allinf) {
            // Проверяет есть ли такая книга
            if (book.getId().equals(id)){
                ids = datainf.allinf.indexOf(book);
                book_de = book;
                exBook = true;
            }

        }
        //Если есть запускаем процесс удаления
        if (exBook){
            //Integer ids = Integer.valueOf(id);
            Integer count = 0;
            //System.out.println(ids);
            datainf.allinf.remove(book_de);
            datainf.booksforgiven.remove(book_de);
            //System.out.println(datainf.allinf);

            String line;
            File sourceFile = new File("books.txt");
            File outputFile = new File("books2.txt");
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
            // Удаляем и переименовываем промежуточные файлы
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
            deleteBookGive(ids);
            System.out.println("Книга удалена");
        } else {
            System.out.println("Книги такой нет");
        }


    }
    // удаляем из файла
    public void deleteBookGive(Integer ids) throws IOException{

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




}   //Возвращаем по категории
    public Integer returnCategory(String category){
        /*for (Book book: datainf.allinf) {
            if (book.getCategory().equals(categories.CLASSIC.getCode())) {
                System.out.println(1);

            }
            else if (book.getCategory().equals(categories.FANTASTIC.getCode())) {
                System.out.println(2);
            }
        }*/

        int countCategoty = 0;
        for (Book book: datainf.allinf) {
            if (book.getCategory().equals(category)) {
                countCategoty++;

            }
        }
        return countCategoty;
    }
    // Показывает книги пользователя
    public String booksUser(String name){
        try {
            datainf.readFileBooks();
            datainf.readFileBooksGive();
            datainf.readFileUser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String booksof = "";
        for (User user: datainf.allUser){
            if (user.getName().equals(name)){
                booksof = user.getBook();
            }
        }
        return booksof;
    }
    //Есть ли книги в библиотеке и у пользователей
    public String existBooks(){
        //,datainf.booksforUsers
        try {
            datainf.readFileBooksGive();
            datainf.readFileBooksBack();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String inf = String.format("В библиотеке сейчас %d книг, у пользователей книг %d", datainf.booksforgiven.size(), datainf.booksforUsers.size() );
        return inf;
    }
    //Все книги
    public void allBooks(){
        String allbook = "";
        for (Book book: datainf.allinf) {
            System.out.println(book.getName());
        }

    }
    // ищем категорию
    public void findCat(String cat){
        categories cat2 = categories.valueOf(cat);
        switch(cat2){
            case Классика:
                System.out.println("Книги по классике есть");
                break;
            case Фантастика:
                System.out.println("Книги по фантастике есть");
            default:
                System.out.println("Книг по такой теме нет");

        }

    }



}
