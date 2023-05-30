package org.example;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    public int compare(Product s1, Product s2) {
        if (s1.date.equals(s2.date)) {
            return 0;
        } else if (s1.date.before(s2.date)) {
            System.out.println(1);
            System.out.println(s1.date);
            System.out.println(s2.date);
            return -1;
        } else if (s1.date.after(s2.date)) {
            System.out.println(2);
            System.out.println(s1.date);
            System.out.println(s2.date);
            return 1;
        }
        return 0;
    }
}
