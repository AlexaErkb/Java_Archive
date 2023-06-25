package fa.ru.exam.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int sum = 0;
        int st = 666;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int n = in.nextInt();
        System.out.println("Введите количество столбцов: ");
        int m = in.nextInt();
        int[][] ar = new int[n][m];
        if (n * m > 6) {
            while (sum != st) {
                sum = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        ar[i][j] = (int) (Math.random() * 100) + 1;
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i == 0 | j == 0 | i == n - 1 | j == m - 1)
                            sum += ar[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ar[i][j] + "   ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Такой матрицы не бывает");
        }
    }
}