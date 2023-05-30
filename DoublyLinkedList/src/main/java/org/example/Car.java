package org.example;

import java.util.Comparator;

public class Car {

    public int manufactureYear;
    public String model;

    public Car(int manufactureYear, String model) {
        this.manufactureYear = manufactureYear;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufactureYear=" + manufactureYear +
                ", model='" + model + '\'' +
                '}';
    }
}


