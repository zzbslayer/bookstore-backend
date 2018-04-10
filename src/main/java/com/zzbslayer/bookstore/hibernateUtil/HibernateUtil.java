package com.zzbslayer.bookstore.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =  
    		new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
