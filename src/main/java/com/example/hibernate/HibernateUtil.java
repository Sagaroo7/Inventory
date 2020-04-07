package com.example.hibernate;

import com.example.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUtil {

    Session session = null;
    SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory()
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

    public Session getSession() {
        session = getSessionFactory().openSession();
        return session;
    }

    public List<Item> allItems()
    {
        Query query = session.createQuery("from Item ");
        List<Item> itemList = query.list();
        return itemList;
//        return getSession().createQuery("FROM Item").list();
    }
}
