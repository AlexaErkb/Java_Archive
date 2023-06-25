package fa.ru.exam.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> collection = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int n = in.nextInt();
        System.out.println("Введите количество столбцов: ");
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            collection.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                collection.get(i).add((int) (Math.random() * 20000 - 10000));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(collection.get(i).get(j) + "   ");
            }
            System.out.println();
        }
    }
}
