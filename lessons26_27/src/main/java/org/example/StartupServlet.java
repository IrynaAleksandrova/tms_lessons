package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/init", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws RuntimeException {
        try {
            Class.forName("org.postgresql.Driver");
            getConnection().createStatement().execute("drop table if exists car");
            getConnection().createStatement().execute("" + "create table  car (" +
                    " id int primary key, " +
                    " model varchar, " +
                    " year varchar, " +
                    " cost int" + ")");
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "17081991");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
