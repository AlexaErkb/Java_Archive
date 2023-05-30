package org.example;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static int punctCounter = 0;
    public static String PUNCT = "!\"'(),.?";
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> str = new ArrayList<>();
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int spaceCounter = 0;
        int intCounter = 0;
        int doubleCounter = 0;
        String old;
        ArrayList<String> base = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                for (int i=0; i<line.length(); i++) {
                    if (Character.isUpperCase(line.charAt(i))) {
                        upperCaseCounter++;
                    } else if (line.charAt(i)==' ') {
                        spaceCounter++;
                    } else if(Character.isLowerCase(line.charAt(i))) {
                        lowerCaseCounter++;
                    }
                }
                String[] text = line.split("\\s+");
                for (int i=0; i<text.length; i++) {
                    switch (isNumber(text[i])) {
                        case 1:
                            old = text[i];
                            while (PUNCT.indexOf(text[i].charAt(text[i].length()-1))!=-1) {
                                text[i] = text[i].substring(0, text[i].length() - 1);
                            }
                            text[i] = String.format("%.2f", Double.parseDouble(text[i]));
                            System.out.println(text[i]);
                            line = line.replaceFirst(old, text[i]);
                            doubleCounter++;
                            break;
                        case 2:
                            old = text[i];
                            while (PUNCT.indexOf(text[i].charAt(text[i].length()-1))!=-1) {
                                text[i] = text[i].substring(0, text[i].length() - 1);
                            }
                            text[i] = Integer.toHexString(Integer.parseInt(text[i]));
                            System.out.println(text[i]);
                            line = line.replaceFirst(old, text[i]);
                            intCounter++;
                            break;
                        default:
                            StringBuilder result = new StringBuilder();
                            for (int j=0; j<text[i].length(); j++) {
                                char c = text[i].charAt(j);
                                if (PUNCT.indexOf(c) < 0) {
                                    result.append(c);
                                } else {
                                    punctCounter++;
                                }
                            }
                            line = line.replaceFirst(text[i], result.toString());
                            text[i] = result.toString();
                            break;
                    }
                    str.add(text[i]);
                }
                base.add(line);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("result.txt");
            myWriter.write("Общее количество слов в тексте: " + str.size() + "\n");
            myWriter.write("Общее количество заглавных букв: " + upperCaseCounter + "\n");
            myWriter.write("Общее количество строчных букв: " + lowerCaseCounter + "\n");
            myWriter.write("Общее количество пробелов: " + spaceCounter + "\n");
            myWriter.write("Общее количество целых чисел: " + intCounter + "\n");
            myWriter.write("Общее количество чисел с плавающей запятой: " + doubleCounter + "\n");
            myWriter.write("Общее количество знаков препинания: " + punctCounter + "\n");
            myWriter.write("Итоговые данные" + "\n");
            for (int i=0; i<base.size(); i++) {
                myWriter.write(base.get(i) + "\n");
            }
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
        System.out.println(str);
        String substr;
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            System.out.println("Введите 1, если хотите что-то найти, или введите 0, если хотите выйти");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите слово которое хотите найти");
                    String find = in.next();
                    for (int i=0; i<base.size(); i++) {
                        if (base.get(i).length()>find.length()) {
                            substr = base.get(i);
                            int count = 0;
                            for (int j=0; j<substr.length(); j++) {
                                if (substr.indexOf(find)>-1) {
                                    System.out.println("Строка " + String.valueOf(i+1) + "\n" + "Индекс первой буквы: " + (substr.indexOf(find)+count*find.length()) + "\n"
                                            + "Индекс последней буквы: " + (substr.indexOf(find)+find.length()-1+count*find.length()) + "\n");
                                    count++;
                                    substr = substr.replaceFirst(find, "");
                                }
                            }
                        }
                    }
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("Попробуйте ввести другое значение");
                }
            }
        }
        //String[] text = s.split("\\s");
        //ArrayList<String> str = new ArrayList<>(Arrays.asList(s));
        //System.out.println(str);

    }
    public static int isNumber(String str) {
        str = str.replace(",", ".");
        while (PUNCT.indexOf(str.charAt(str.length()-1))!=-1) {
            str = str.substring(0, str.length() - 1);
            punctCounter++;
        }
        try {
            if (str.contains(".")){
                double v = Double.parseDouble(str);
                return 1;
            } else {
                int i = Integer.parseInt(str);
                return 2;
            }

        } catch (Exception e) {
            return 3;
        }
    }
}
