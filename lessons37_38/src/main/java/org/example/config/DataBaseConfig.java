package org.example.config;

import org.example.domain.Course;
import org.example.domain.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

@Configuration
public class DataBaseConfig {

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        Properties properties = new Properties();
        properties.put(DRIVER, "org.postgresql.Driver");
        properties.put(URL, "jdbc:postgresql://localhost:49153/postgres");
        properties.put(USER, "postgres");
        properties.put(PASS, "");
        properties.put(DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(HBM2DDL_AUTO, "create-drop");
        properties.put(SHOW_SQL, "true");

        configuration.addProperties(properties);

        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Course.class);

        return configuration.buildSessionFactory();
    }
}
