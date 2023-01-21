package org.tms.decorator_car;

import org.tms.decorator_car.domain.Car;
import org.tms.decorator_car.service.impl.CacheCarServiceImpl;
import org.tms.decorator_car.service.CarService;
import org.tms.decorator_car.service.impl.CarServiceImpl;

public class MainApp {

    public static void main(String[] args) {

        Car tesla = new Car(1, "Tesla", "2020");
        Car audi = new Car(2, "Audi", "2015");
        Car ford = new Car(3, "Ford", "2012");

        CarService carService = new CacheCarServiceImpl(new CarServiceImpl());      //decorator
        carService.save(tesla);
        carService.save(audi);
        carService.save(ford);

        carService.delete(1);
        carService.getById(2);
        carService.update(ford);
        Car ford1 = new Car(3, "Ford", "2013");
        carService.update(ford1);

    }
}
