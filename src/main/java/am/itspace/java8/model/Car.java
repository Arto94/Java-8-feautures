package am.itspace.java8.model;

import am.itspace.java8.service.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car implements Vehicle {

    private final String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }
}