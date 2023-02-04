package org.tms.decorator_car.service.impl;

import lombok.Data;
import org.tms.decorator_car.domain.Car;
import org.tms.decorator_car.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CacheCarServiceImpl implements CarService {
    private CarService carService;
    private List<Car> cacheCar = new ArrayList<>();

    public CacheCarServiceImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    public Car save(Car car) {
        boolean value = cacheCar.stream().anyMatch(car1 -> car1.equals(car));
        if (!value) {
            cacheCar.add(car);
            System.out.println(car + " cached!");
        } else {
            System.out.println(car + " already in the cache");
        }
        carService.save(car);
        return car;
    }

    @Override
    public void delete(int id) {
        boolean value = cacheCar.stream().anyMatch(car -> car.getId() == id);
        if (value) {
            cacheCar.removeIf(car -> car.getId() == id);
            System.out.println("The car with id " + id + " deleted from cache");
            carService.delete(id);
        } else {
            System.out.println("id " + id + " not in cache");
        }
    }

    @Override
    public Car getById(int id) {
        boolean value = cacheCar.stream().anyMatch(car -> car.getId() == id);
        if (value) {
            List<Car> listCar = cacheCar.stream().filter(car -> car.getId() == id).collect(Collectors.toList());
            System.out.println(listCar);
        } else {
            System.out.println("id " + id + " was not found in the cache");
            carService.getById(id);
        }
        return carService.getById(id);
    }

    @Override
    public Car update(Car car) {
        List<Car> listCar = cacheCar.stream().filter(car1 -> car1.getId() == car.getId()).toList();
        cacheCar.remove(listCar);

        return carService.update(car);
    }
}
