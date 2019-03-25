package am.itspace.java8.model;

import am.itspace.java8.service.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Motorbike implements Vehicle {

    private final String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The motorbike is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The motorbike is slowing down.";
    }
}