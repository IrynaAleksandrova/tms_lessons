package org.tms.decorator_car.service;

import org.tms.decorator_car.domain.Car;

public interface CarService {

    Car save(Car car);
    void delete(int id);
    Car getById(int id);
    Car update(Car car);

}
