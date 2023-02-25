package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Course;
import org.example.domain.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RenovationService extends AbstractService {

    public void save(Teacher teacher) {
        Session session = get();
        session.save(teacher);

        Course course = teacher.getCourse();
        course.setTeacher(teacher);
        session.save(course);

        System.out.println("The teacher was saved from DB");

        close(session);
    }

    public Teacher getTeacher(Integer id) {
        Session session = get();
        Teacher teacher = session.find(Teacher.class, id);
        close(session);
        return teacher;
    }

    public Course getCourse(Integer id) {
        Session session = get();
        Course course = session.find(Course.class, id);
        close(session);
        return course;
    }

    public void delete(Integer id) {
        Session session = get();
        Teacher teacher = session.find(Teacher.class, id);
        Course course = session.find(Course.class, id);
        session.delete(teacher);
        session.delete(course);

        System.out.println("The teacher " + teacher.getId() + " was deleted from DB");

        close(session);
    }

}