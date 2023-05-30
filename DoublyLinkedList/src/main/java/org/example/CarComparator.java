package org.example;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    public int compare(Car s1, Car s2) {
        if (s1.manufactureYear > s2.manufactureYear) {
            return -1;
        } else if ( s1.manufactureYear < s2.manufactureYear ) {
            return 1;
        }
            return 0;
    }
}
