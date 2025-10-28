package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user = User.builder().name("Toto").age(19).build();

        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();

//        session.beginTransaction();
//        User user = session.find(User.class,1);
//        user.setAge(25);
//        session.getTransaction().commit();

//        session.beginTransaction();
//        User user = session.find(User.class,1);
//        session.remove(user);
//        session.getTransaction().commit();

//        String request = "select u from User u";
//        Query<User> query = session.createQuery(request, User.class);
//        List<User> users= query.getResultList();
//        System.out.println(users);

        String request = "select u from User u where u.id = :id";
        Query<User> query = session.createQuery(request, User.class);
        query.setParameter("id",3);
        User users= query.getSingleResult();
        System.out.println(users);


    }
}