package org.example.utils;

import org.example.entity.Customer;
import org.example.entity.Sell;
import org.example.entity.SellProduct;
import org.example.entity.product.Product;
import org.example.entity.product.ProductCloth;
import org.example.entity.product.ProductElectronic;
import org.example.entity.product.ProductFood;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionfactorySingleton {

    private static SessionFactory sessionFactory;

    private SessionfactorySingleton() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductElectronic.class);
        configuration.addAnnotatedClass(ProductFood.class);
        configuration.addAnnotatedClass(ProductCloth.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Sell.class);
        configuration.addAnnotatedClass(SellProduct.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory (){
        if(sessionFactory == null){
            new SessionfactorySingleton();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory (){
        if(!sessionFactory.isClosed()){
            sessionFactory.close();
        }
    }
}
