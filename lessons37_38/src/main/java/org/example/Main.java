package org.example;

import org.example.domain.Course;
import org.example.domain.Information;
import org.example.domain.Role;
import org.example.domain.Student;
import org.example.domain.Teacher;
import org.example.service.CoursesService;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        TeacherService teacherService = context.getBean(TeacherService.class);
        CoursesService coursesService = context.getBean(CoursesService.class);

        Course course1 = new Course("Java");
        Course course2 = new Course("JavaScript");
        Course course3 = new Course("Python");
        Course course4 = new Course("C++");
        Course course5 = new Course("Assembly language");

        Teacher teacher1 = new Teacher();
        teacher1.setFullName("Sergey Makarov");
        Information information1 = new Information(7, "Belarus");
        teacher1.setInformation(information1);
        teacher1.setBeginLesson(new Date(1662397200000L));
        teacher1.setOnline(true);
        teacher1.setCourses(List.of(course1, course2, course4));
        teacher1.setRole(Role.MENTORING);

        Teacher teacher2 = new Teacher();
        teacher2.setFullName("Andrey Brodvey");
        Information information2 = new Information(4, "Poland");
        teacher2.setInformation(information2);
        teacher2.setBeginLesson(new Date(1684170000000L));
        teacher2.setOnline(true);
        teacher2.setCourses(List.of(course3, course5));
        teacher2.setRole(Role.MENTORING);

        Teacher teacher3 = new Teacher();
        teacher3.setFullName("Ruslan Maslam");
        Information information3 = new Information(10, "Iran");
        teacher3.setInformation(information3);
        teacher3.setBeginLesson(new Date(1670864400000L));
        teacher3.setOnline(true);
        teacher3.setCourses(List.of(course2, course3, course5));
        teacher3.setRole(Role.CONSULTANCY);

        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);
        teacherService.saveTeacher(teacher3);

        Student student1 = new Student();
        student1.setFullName("Mark Morozov");
        student1.setCourses(List.of(course1, course5));
        student1.setRole(Role.LEARNING);

        Student student2 = new Student();
        student2.setFullName("Marina Sweet");
        student2.setCourses(List.of(course2, course4));
        student2.setRole(Role.LEARNING);

        Student student3 = new Student();
        student3.setFullName("Vadim Popov");
        student3.setCourses(List.of(course2));
        student3.setRole(Role.LEARNING);

        coursesService.saveCourse(student1);
        coursesService.saveCourse(student2);
        coursesService.saveCourse(student3);

        coursesService.addCourse(course1, student1);
        coursesService.addCourse(course5, student1);

        coursesService.addCourse(course2, student2);
        coursesService.addCourse(course4, student2);

        coursesService.addCourse(course2, student3);
        System.out.println("------------------");

        coursesService.deleteCourse(course2, student2);
        System.out.println("------------------");

        teacherService.getTeacher(1);
        coursesService.getCourse(1);
        coursesService.getCourse(2);
        coursesService.getCourse(4);


//        teacherService.deleteTeacher(1);
    }
}