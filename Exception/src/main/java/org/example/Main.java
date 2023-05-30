package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[] {1, 3, 5, 7, 8};
        try{
            for (int i=0; i<list.length; i++) {
                if (list[i]%5==0) {
                    throw new AlexandraException("Индекс первого элемента, делящегося на 5 - " + i);
                } else {
                    System.out.println(list[i]);
                }
            }
        }
        catch(AlexandraException ex){
            System.out.println(ex.getMessage());
        }
    }
}
