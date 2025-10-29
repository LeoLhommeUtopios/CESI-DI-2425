package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Orders.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(OrdersProduct.class);
//        configuration.addAnnotatedClass(Account.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

//        User user = User.builder().name("Toto").age(19).build();

//        session.beginTransaction();
//        session.persist(user);
//        session.getTransaction().commit();

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

//        String request = "select u from User u where u.id = :id";
//        Query<User> query = session.createQuery(request, User.class);
//        query.setParameter("id",3);
//        User users= query.getSingleResult();
//        System.out.println(users);

//        Account account = Account.builder().email("email@email.com").password("password").build();
//        User user = User.builder().age(43).name("user1").account(account).build();
//        session.beginTransaction();
////        session.persist(account);
//        session.persist(user);
//        session.getTransaction().commit();
//
//        System.out.println(session.find(User.class,1));
//
//
//        Orders order = Orders.builder().codeProduct("123GFH123T6").orderDate(LocalDate.now()).user(user).build();
//        Orders order2 = Orders.builder().codeProduct("123GFH123T6").orderDate(LocalDate.now()).user(user).build();
//        Orders order3 = Orders.builder().codeProduct("123GFH123T6").orderDate(LocalDate.now()).user(user).build();
//
//        session.beginTransaction();
//        session.persist(order);
//        session.persist(order2);
//        session.persist(order3);
//        session.getTransaction().commit();
//
//        System.out.println(session.find(User.class,1));
//
//        Product product = Product.builder().name("banane").price(0.6f).build();
//        Product product1 = Product.builder().name("pomme").price(0.6f).build();
//        Product product2 = Product.builder().name("piles").price(0.6f).build();
//
//        session.beginTransaction();
//        session.persist(product);
//        session.persist(product1);
//        session.persist(product2);
//        session.getTransaction().commit();
//
//
//        OrdersProduct ordersProduct1 = OrdersProduct.builder().product(product).orders(order).quantity(2).build();
//        OrdersProduct ordersProduct2 = OrdersProduct.builder().product(product2).orders(order2).quantity(3).build();
//        OrdersProduct ordersProduct3 = OrdersProduct.builder().product(product1).orders(order3).quantity(5).build();
//        OrdersProduct ordersProduct4 = OrdersProduct.builder().product(product2).orders(order3).quantity(43).build();
//        OrdersProduct ordersProduct5 = OrdersProduct.builder().product(product).orders(order2).quantity(5).build();
//
//
//        session.beginTransaction();
//        session.persist(ordersProduct1);
//        session.persist(ordersProduct2);
//        session.persist(ordersProduct3);
//        session.persist(ordersProduct4);
//        session.persist(ordersProduct5);
//        session.getTransaction().commit();

        System.out.println(session.find(User.class,1));
    }
}