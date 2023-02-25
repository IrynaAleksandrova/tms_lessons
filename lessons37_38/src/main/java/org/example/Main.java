package org.example;

import org.example.domain.Course;
import org.example.domain.Information;
import org.example.domain.Role;
import org.example.domain.Teacher;
import org.example.service.RenovationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        RenovationService trainingService = context.getBean(RenovationService.class);

        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();

        teacher1.setName("Sergey Makarov");
        Information information1 = new Information("Java", 7, "Belarus");
        teacher1.setInformation(information1);
        teacher1.setBeginLesson(new Date(1662397200000L));
        teacher1.setOnline(true);
        Course course1 = new Course();
        course1.setTitle("Java");
        teacher1.setCourse(course1);
        teacher1.setRole(Role.LEARNING);

        teacher2.setName("Andrey Brodvey");
        Information information2 = new Information("JS", 4, "Poland");
        teacher2.setInformation(information2);
        teacher2.setBeginLesson(new Date(1684170000000L));
        teacher2.setOnline(true);
        Course course2 = new Course();
        course2.setTitle("JS");
        teacher2.setCourse(course2);
        teacher2.setRole(Role.MENTORING);

        teacher3.setName("Ruslan Maslan");
        Information information3 = new Information("Python", 10, "Iran");
        teacher3.setInformation(information3);
        teacher3.setBeginLesson(new Date(1670864400000L));
        teacher3.setOnline(true);
        Course course3 = new Course();
        course3.setTitle("Python");
        teacher3.setCourse(course3);
        teacher3.setRole(Role.CONSULTANCY);

        trainingService.save(teacher1);
        trainingService.save(teacher2);
        trainingService.save(teacher3);

        Teacher getTeacher = trainingService.getTeacher(3);
        System.out.println("Teacher number 3 is " + getTeacher);

        Course getCourse = trainingService.getCourse(1);
        System.out.println("Course number 1 is " + getCourse);

        trainingService.delete(2);
        System.out.println("Teacher number 2 was deleted");
    }
}