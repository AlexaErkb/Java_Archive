package org.example;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"Местный", "Из близлежащего города", "Из дальнего города"};
        Scanner in = new Scanner(System.in);
        PriorityQueue<Product> pq = new PriorityQueue<>(new ProductComparator());
        Product product1 = new Product("Apple",  new Date(2020, 10, 10));
        Product product2 = new Product("Peer",  new Date(2020, 9, 9));
        Product product3 = new Product("Watermelon",  new Date(2020, 8, 8));
        pq.add(product1);
        pq.add(product2);
        pq.add(product3);
        for (Product product : pq) {
            System.out.println("Имя: " + product.getName() +
                    " Дата: " + product.getDate());
        }
        System.out.println(new Date(2020, 10, 10).after(new Date(2020, 9, 9)));
    }
}
