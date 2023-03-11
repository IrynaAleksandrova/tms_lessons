package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session get() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void close(Session session) {
        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }

}
