package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Employee {

    public static void main(String[] args) {
        System.out.print("Вводите информацию о сотрудниках пока их не будет 100, либо введите 0, чтобы закончить\n");
        Scanner in = new Scanner(System.in);
        List<String> data = new ArrayList<>(100);
        ArrayList<ArrayList<String>> base = new ArrayList<>();
        String columnNames = "Id\tИмя\tФамилия\tГод_рождения\tМесто_рождения\tЗарплата\tСемейное_положение";
        int count = 0;
        String x;
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<Integer> years = new ArrayList<>();
        ArrayList<String> places = new ArrayList<>();
        ArrayList<Integer> salaries = new ArrayList<>();
        ArrayList<Boolean> families = new ArrayList<>();
        int choice = -1;
        while (choice!=8) {
            System.out.print(
                    """
                    ================ Выбор команд =============
                    1 - Добавить данные о сотрудниках
                    2 - Найти сотрудника по id
                    3 - Найти всех сотрудников с этим именем
                    4 - Найти всех сотрудников с этой датой рождения
                    5 - Поменять данные сотрудника по id
                    6 - Посчитать общую сумму всех зарплат
                    7 - Вывести данные о сотрудниках
                    8 - Выйти
                    """);

            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    count = base.size();
                    do {
                        System.out.print("Введите через запятую идентификатор, имя, фамилию, год рождения, место рождения, зарплату, семейное положение: ");
                        x = in.next();
                        String[] strArr = x.split(",");
                        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));
                        if ((list.size() < 7 || ids.contains(list.get(0))) && !x.equals("0")) {
                            System.out.println("Вы ввели неверные данные");
                        } else if (!x.equals("0")) {
                            ids.add(list.get(0));
                            names.add(list.get(1));
                            surnames.add(list.get(2));
                            years.add(Integer.parseInt(list.get(3)));
                            places.add(list.get(4));
                            salaries.add(Integer.parseInt(list.get(5)));
                            families.add(Boolean.parseBoolean(list.get(6)));
                            data.add(x);
                            base.add(list);
                        }
                        count++;
                    } while (!x.equals("0") && count < 100);
                    System.out.println(count);
                    System.out.println(base);
                }
                case 2 -> {
                    try {
                        int ind = ids.indexOf(in.next());
                        System.out.println(base.get(ind));
                    } catch (Exception e) {
                        System.out.println("Сотрудника с таким id нет, вы можете добавить его, написав цифру 1");
                    }
                }
                case 3 -> {
                    System.out.println("Введите имя");
                    String s = in.next();
                    int c = 0;
                    for (int i=0; i<base.size(); i++) {
                        if (names.get(i).equals(s)) {
                            System.out.println(base.get(i));
                            c++;
                        }
                    }
                    if (c==0) {
                        System.out.println("Нет сотрудников с таким именем");
                    }

                }
                case 4 -> {
                    System.out.println("Введите год рождения");
                    int n = in.nextInt();
                    int c = 0;
                    for (int i=0; i<base.size(); i++) {
                        if (years.get(i).equals(n)) {
                            System.out.println(base.get(i));
                            c++;
                        }
                    }
                    if (c==0) {
                        System.out.println("Нет сотрудников с таким именем");
                    }
                }
                case 5 -> {
                    try {
                        System.out.println("Введите id сотрудника, информацию о котором хотите поменять");
                        int ind = ids.indexOf(in.next());
                        System.out.print(
                                """
                                Введите номер позиции которую хотите изменить 
                                1 - id
                                2 - Имя
                                3 - Фамилия
                                4 - Год рождения
                                5 - Место рождения
                                6 - Зарплата
                                7 - Семейное положение
                                """);
                        int position = in.nextInt()-1;
                        System.out.println("Введите то, чем хотите заменить");
                        String replace = in.next();
                        if (position == 0 || position == 1 || position == 2 || position == 4) {
                            switch (position) {
                                case 0 -> {
                                    ids.set(ind, replace);
                                }
                                case 1 -> {
                                    names.set(ind, replace);
                                }
                                case 2 -> {
                                    surnames.set(ind, replace);
                                }
                                case 4 -> {
                                    places.set(ind, replace);
                                }
                            }
                        } else if (position == 3 || position == 5) {
                            switch (position) {
                                case 3 -> {
                                    years.set(ind, Integer.parseInt(replace));
                                }
                                case 5 -> {
                                    System.out.println(32);
                                    salaries.set(ind, Integer.parseInt(replace));
                                }
                            }
                        } else {
                            families.set(ind, Boolean.parseBoolean(replace));
                        }
                        base.get(ind).set(position, replace);
                        System.out.println(base);
                    } catch (Exception e) {
                        System.out.println("Вы ввели неверные данные");
                    }
                }
                case 6 -> {
                    int s = 0;
                    for (int i=0; i<base.size(); i++) {
                        s = s + salaries.get(i);
                    }
                    System.out.println("Суммарная зарплата всех сотрудников: " + s);
                }
                case 7 -> {
                    System.out.println(base);
                }
                case 8 -> {
                    break;
                }
                default -> {
                    System.out.println("Попробуйте ввести другое значение");
                }
            }
        }
    }
}

