package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Course;
import org.example.domain.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService extends AbstractService {

    public void saveTeacher(Teacher teacher) {
        Session session = get();
        List<Course> courses = teacher.getCourses();
        session.save(teacher);
        courses.forEach(session::save);
        courses.forEach(course -> course.setTeacher(teacher));
        close(session);
    }

    public Teacher getTeacher(Integer id) {
        Session session = get();
        Teacher teacher = session.find(Teacher.class, id);
        close(session);
        return teacher;
    }

    public void deleteTeacher(Integer id) {
        Session session = get();
        Teacher teacher = session.find(Teacher.class, id);
        List<Course> courses = teacher.getCourses();
        System.out.println(courses);
        courses.forEach(session::delete);
        session.delete(teacher);
        System.out.println("The teacher " + teacher.getId() + " was deleted from DB");
        close(session);
    }
}