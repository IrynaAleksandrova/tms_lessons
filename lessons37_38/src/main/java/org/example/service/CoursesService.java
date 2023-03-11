package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Course;
import org.example.domain.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService extends AbstractService {

    public void saveCourse(Student student) {
        Session session = get();
        session.save(student);
        close(session);
    }

    public void addCourse(Course course, Student student) {
        Session session = get();
        Course courseById = session.get(Course.class, course.getId());
        Student studentById = session.get(Student.class, student.getId());
        List<Student> students = courseById.getStudents();
        students.add(studentById);
        courseById.setStudents(students);
        close(session);
    }

    public Course getCourse(Integer id) {
        Session session = get();
        Course course = session.find(Course.class, id);
        close(session);
        return course;
    }

    public void deleteCourse(Course course, Student student) {
        Session session = get();
        Course courseById = session.get(Course.class, course.getId());
        Student studentById = session.find(Student.class, student.getId());
        List<Student> students = courseById.getStudents();
        students.remove(studentById);
        courseById.setStudents(students);
        close(session);
    }
}
