package org.example;

import java.util.Scanner;

enum daysOfWeek{
    MONDAY("a"),
    TUESDAY("b"),
    WEDNESDAY("c"),
    THURSDAY("d"),
    FRIDAY("e"),
    SATURDAY("f"),
    SUNDAY("g");
    private String code;
    daysOfWeek(String representation) {
        this.code = representation;
    }
    public String getCode() {
        return code;
    }
}

public class Main {
    public static void main(String[] args) {
        for (daysOfWeek day:daysOfWeek.values()) {
            System.out.println(day);
        }
        System.out.println("Enter day of the week: ");
        Scanner in = new Scanner(System.in);
        daysOfWeek day = daysOfWeek.valueOf(in.next());
        System.out.println(day);
        switch (day) {
            case FRIDAY:
                System.out.println(String.format("%s is holiday in some countries", daysOfWeek.FRIDAY.getCode()));
                break;
            case TUESDAY:
                System.out.println("Tuesday is workday everywhere");
                break;
        }
    }
}
