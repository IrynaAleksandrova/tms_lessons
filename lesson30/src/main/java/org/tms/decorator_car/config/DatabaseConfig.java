package org.tms.decorator_car.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public void initialization(){
        try {
            Class.forName("org.postgresql.Driver");
            getConnection().createStatement().execute("drop table if exists car");
            getConnection().createStatement().execute("" + "create table  car (" +
                    " id int primary key, " +
                    " model varchar, " +
                    " year varchar " + ")");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problem with initialization!");
            throw new RuntimeException();
        }
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:49153/postgres", "postgres", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
