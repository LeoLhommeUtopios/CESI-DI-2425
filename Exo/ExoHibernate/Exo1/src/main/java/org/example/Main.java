package org.example;

import org.example.DAO.ProductDAO;
import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(Product.class);

        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        ProductDAO productDAO = new ProductDAO(session);

        Product product = Product.builder().brand("brand1").price(12.5).buyingDate(LocalDate.now()).stock(120).build();
        Product product2 = Product.builder().brand("brand2").price(12.5).buyingDate(LocalDate.now()).stock(120).build();
        Product product3 = Product.builder().brand("brand3").price(12.5).buyingDate(LocalDate.now()).stock(120).build();
        Product product4 = Product.builder().brand("brand4").price(12.5).buyingDate(LocalDate.now()).stock(120).build();
        Product product5 = Product.builder().brand("brand5").price(12.5).buyingDate(LocalDate.now()).stock(120).build();

        productDAO.save(product);
        productDAO.save(product2);
        productDAO.save(product3);
        productDAO.save(product4);
        productDAO.save(product5);

        System.out.println(productDAO.getAll());

        System.out.println(productDAO.getById(2));

        productDAO.delete(3);

        Product productUpdate = Product.builder().brand("new Brand").price(25.78).buyingDate(LocalDate.now()).stock(200).build();
        productDAO.update(1,productUpdate);
    }
}