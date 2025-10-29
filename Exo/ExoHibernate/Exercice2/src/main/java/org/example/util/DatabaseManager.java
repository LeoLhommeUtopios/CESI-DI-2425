package org.example.util;

import org.example.entity.Ordinateur;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {

    private static SessionFactory sessionFactory;

    private DatabaseManager() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Ordinateur.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null) new DatabaseManager();
        return sessionFactory;
    }
}
