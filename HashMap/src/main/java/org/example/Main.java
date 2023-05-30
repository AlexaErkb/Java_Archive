package org.example;

import java.io.*;
import java.util.*;

public class Main {
    final static String filePath
            = "write.txt";
    public static void main(String[] args)
    {
        Map<String, String> mapFromFile = HashMapFromTextFile();
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            System.out.println("Введите 1, если хотите вывести все слова со значениями\n" +
                    "Введите 2, если хотите найти слово по значению\n" +
                    "Введите 3, если хотите найти значение по слову\n" +
                    "Введите 0, если хотите выйти");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                }
                case 2 -> {
                    boolean flag = false;
                    System.out.println("Введите значение: ");
                    String find = in.next();
                    for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
                        if (find.equals(entry.getValue())) {
                            flag = true;
                            System.out.println(entry.getKey());
                        }
                    }
                    if (!flag) {
                        System.out.println("Нет слова с таким значением");
                    }
                }
                case 3 -> {
                    boolean flag = false;
                    System.out.println("Введите слово: ");
                    String find = in.next();
                    for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
                        if (find.equals(entry.getKey())) {
                            flag = true;
                            System.out.println(entry.getValue());
                        }
                    }
                    if (!flag) {
                        System.out.println("Нет значения для этого слова");
                    }
                }
            }
        }
    }

    public static Map<String, String> HashMapFromTextFile()
    {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader br = null;
        try {
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String number = parts[1].trim();
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
