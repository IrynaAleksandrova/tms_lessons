package org.tms.decorator_car.service.impl;

import org.tms.decorator_car.config.DatabaseConfig;
import org.tms.decorator_car.domain.Car;
import org.tms.decorator_car.service.CarService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarServiceImpl implements CarService {

    private final DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public Car save(Car car) {
        databaseConfig.initialization();
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into car (id, model, year) values(?, ?, ?)")) {
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getYear());
            System.out.println(car + " saved in Database!");
            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("Save Exception in Database");
        }
        return car;
    }

    @Override
    public void delete(int id) {
        databaseConfig.initialization();
        try (Connection connection = databaseConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("Delete Exception in Database");
        }
        System.out.println("The car with id " + id + " deleted in Database");
    }

    @Override
    public Car getById(int id) {
        databaseConfig.initialization();
        try (Connection connection = databaseConfig.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from car where id = ?");
            statement.setInt(1, id);
        } catch (Exception exc) {
            throw new RuntimeException("This ID not founded in DataBase");
        }
        return new Car();
    }

    @Override
    public Car update(Car car) {
        databaseConfig.initialization();
        try (Connection connection = databaseConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update car set id = ? where model = ?");
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("Update Exception in Database");
        }
        System.out.println(car + " updated in Database");
        return car;
    }
}
