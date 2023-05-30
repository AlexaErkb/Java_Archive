package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        // Переменная для считывания информации из файлов
        DataInf dtinf = new DataInf();
        // Считывания информации из файлов
        try {
            dtinf.readFileBooks();
            dtinf.readFileManager();
            dtinf.readFileWorker();
            dtinf.readFileUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Manager p1  = dtinf.allMang.get(0);
        System.out.println(p1.getName());*/
       /* String[] n = returnBooks(dtinf);
        System.out.println(n[2]);*/
        //User user2 = dtinf.allUser.get(1);
        //System.out.println(user2.getName()+user2.getSurname());

        int ch; // for storing user's choice
        // double ar; // for storing area
        // variable for storing various dimensions of
        // different geometrical figure
        // Сканер для ввода данных
        Scanner in = new Scanner(System.in); // creating object of Scanner class


        // displaying the menu
        // Ввод цикла, чтобы меню отображалось каждый раз
        lp:
        while (true) {
            System.out.println("Войдите в систему как: ");
            System.out.println("1: Менеджер");
            System.out.println("2: Библиотечный работник");
            System.out.println("3: Читатель");
            System.out.println("4: Выход");
            System.out.print("Вы выбираете: ");
            ch = in.nextInt(); // выбор пользователя
            switch (ch) {
                case 1:
                    System.out.println("Введите имя и фамилию через запятую");
                    String name = in.next();
                    String[] nameOfManager = name.split(","); //Разделение данных, полученных от пользователя по запятой

                    boolean existMan = false;
                    int IdMan = 0;

                    for (Manager manager : dtinf.allMang) {
                        // Проверка есть ли такой менеджер
                        if ((manager.getName().equals(nameOfManager[0])) & (manager.getSurname().equals(nameOfManager[1]))) {
                            System.out.println("Вы вошли в систему");
                            IdMan = Integer.valueOf(manager.getId());
                            existMan = true;

                        }

                    }
                    if (existMan) {
                        // Получение доступа к аккаунту менеджера
                        Manager manager = dtinf.allMang.get(IdMan);

                        lp2:
                        while (true) {
                            System.out.println("1 - добавить книгу");
                            System.out.println("2 - удалить книгу");
                            System.out.println("3 - Сколько книг было взято читателями и сколько еще находится в\n" +
                                    "библиотеке");
                            System.out.println("4 - Сколько книг по конкретной теме.");
                            System.out.println("5 - Какие книги брал конкретный читатель");
                            System.out.println("6 - вывести все книги");
                            System.out.println("7- есть ли книги по определенной категории");
                            System.out.println("8- выход");
                            System.out.print("Вы выбираете: ");
                            int ch1 = in.nextInt();
                            switch (ch1) {
                                case 1:
                                    System.out.println("Введите данные книгу через запятую, если книга имеет название big, добавьте одинарные ковычки");
                                    String newBook = in.next();
                                    String[] inf = newBook.split(",");
                                   /* for(int i=0;i<inf.length;i++){
                                        System.out.println(inf[i]);
                                    }*/
                                    String id = inf[0];
                                    String nameBook = inf[1];
                                    String auth = inf[2];
                                    String edition = inf[3];
                                    String publisher = inf[4];
                                    String year = inf[5];
                                    String category = inf[6];

                                    // 3,Чума,Камю Альбер,книга,ACT,2021,Классика
                                    manager.addBooks(id, nameBook, auth, edition, publisher, year, category);
                                    break;
                                case 2:
                                    System.out.println("Введите id книги для удаления");
                                    String deleteBook = in.next();
                                    manager.deleteBook(deleteBook);
                                    break;
                                case 3:
                                    String data = manager.existBooks();
                                    System.out.println(data);
                                    break;
                                case 4:

                                    boolean m = false;
                                    while (!m) {
                                        System.out.println("Введите тему");
                                        String categoryBook = in.next();

                                        if (categoryBook.equals("q")) {
                                            m = true;
                                        } else {
                                            Integer dataCat = manager.returnCategory(categoryBook);
                                            System.out.println("Книг по теме " + categoryBook + " " + dataCat);
                                        }

                                    }

                                    break;
                                case 5:
                                    System.out.println("Введите имя читателя");
                                    String nameUserBook = in.next();
                                    System.out.println("Пользователь " + nameUserBook + " читает книги: " + manager.booksUser(nameUserBook));
                                    break;
                                case 6:
                                    manager.allBooks();

                                    break;
                                case 7:
                                    System.out.println("Введите категорию");
                                    String categoryBook = in.next();
                                    manager.findCat(categoryBook);

                                    break;
                                case 8:
                                    System.out.println("Выход из системы");
                                    break lp2;

                                default:
                                    System.out.println("Ошибка! \n\n");
                            }
                        }

                    } else {
                        System.out.println("Такого менеджера нет");
                    }
                    break;
                case 2:
                    System.out.println("Введите имя и фамилию через запятую");
                    String nameLabWork = in.next();
                    String[] nameOfLabWorker = nameLabWork.split(",");
                    boolean existLabWork = false;
                    int IdWorker = 0;
                    for (Worker worker : dtinf.allWork) {
                        //Проверка есть ли такой работник
                        if ((worker.getName().equals(nameOfLabWorker[0])) & (worker.getSurname().equals(nameOfLabWorker[1]))) {
                            System.out.println("Вы вошли в систему");
                            IdWorker = Integer.valueOf(worker.getId());
                            existLabWork = true;

                        }
                    }
                    if (existLabWork) {
                        Worker worker = dtinf.allWork.get(IdWorker);
                        String tryFindBook = "";

                        lp3:
                        while (true) {
                            System.out.println("1 - искать книгу");
                            System.out.println("2 - отдать книгу пользователю");
                            System.out.println("3 - выход");
                            System.out.print("Вы выбираете: ");
                            int ch2 = in.nextInt();
                            switch (ch2) {
                                case 1:
                                    System.out.println("Введите книгу для поиска");
                                    tryFindBook = in.next();
                                    String resBook = worker.findBook(tryFindBook);
                                    if (resBook.equals("")) {
                                        System.out.println("Книги нет в данный момент");
                                    } else {
                                        System.out.println("Книгу, которую надо было найти " + resBook);
                                    }
                                    break;
                                case 2:
                                    if (tryFindBook.equals("")) {
                                        System.out.println("Введите книгу для поиска: ");
                                        tryFindBook = in.next();
                                    }
                                    System.out.println("Введите имя и фамилию через запятую читателя для передачи книги");
                                    String nameUser = in.next();
                                    String[] nameOfUser = nameUser.split(",");
                                    boolean existUser = false;
                                    int IdUser = 0;
                                    for (User user : dtinf.allUser) {
                                        if ((user.getName().equals(nameOfUser[0])) & (user.getSurname().equals(nameOfUser[1]))) {
                                            IdUser = Integer.valueOf(user.getId());
                                            existUser = true;

                                        }
                                    }
                                    if (existUser) {
                                        User user = dtinf.allUser.get(IdUser);
                                        user.getforUser(tryFindBook);
                                    } else {
                                        System.out.println("Такого читателя нет");
                                    }

                                    break;
                                case 3:
                                    System.out.println("Выход из системы");

                                    break lp3;
                                default:
                                    System.out.println("Ошибка! \n\n");
                            }
                        }
                    } else {
                        System.out.println("Такого работника нет");
                    }
                    break;
                case 3:
                    System.out.println("Введите имя и фамилию через запятую");
                    String nameUser = in.next();
                    String[] nameOfUser = nameUser.split(",");
                    boolean existUser = false;
                    int IdUser = 0;
                    for (User user : dtinf.allUser) {
                        //Проверка есть ли такой пользователь
                        if ((user.getName().equals(nameOfUser[0])) & (user.getSurname().equals(nameOfUser[1]))) {
                            System.out.println("Вы вошли в систему");
                            IdUser = Integer.valueOf(user.getId());
                            existUser = true;

                        }
                    }
                    if (existUser) {
                        User user = dtinf.allUser.get(IdUser);
                        String tryFindBook = "";

                        lp4:
                        while (true) {
                            System.out.println("1 - взять книгу");
                            System.out.println("2 - отдать книгу");
                            System.out.println("3 - посмотреть книги которые читает");
                            System.out.println("4 - какие книги есть в библиотеке");
                            System.out.println("5 - выход");
                            System.out.print("Вы выбираете: ");
                            int ch3 = in.nextInt();
                            switch (ch3) {
                                case 1:
                                    System.out.println("Введите книгу, которую вы хотите взять");
                                    tryFindBook = in.next();
                                    user.getforUser(tryFindBook);
                                    System.out.println(user.getBook());
                                    break;
                                case 2:
                                    System.out.println("Введите книгу, которую вы хотите отдать");
                                    String tryGiveBook = in.next();
                                    user.giveForUser(tryGiveBook);
                                    break;
                                case 3:
                                    user.showMyBook();
                                    break;
                                case 4:
                                    user.showBooks();
                                    break;
                                case 5:
                                    System.out.println("Выход из системы");
                                    break lp4;
                                default:
                                    System.out.println("Ошибка! \n\n");

                            }
                        }
                    } else {
                        System.out.println("Такого читателя нет");
                    }
                    break;


                case 4:

                    break lp;
                default:
                    System.out.println("Ошибка! \n\n");
            }
        }

    }
}
