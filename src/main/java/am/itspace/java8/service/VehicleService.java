package am.itspace.java8.service;

import am.itspace.java8.model.Car;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public  void print(){
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        System.out.println(Vehicle.getHorsePower(2500, 480));
    }
}
