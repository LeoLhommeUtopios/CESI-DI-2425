package org.example;

import org.example.entity.Product;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.entity.ProductHousing;
import org.example.repository.ProductRepository;
import org.example.util.ProductClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductFood.class);
        configuration.addAnnotatedClass(ProductElectronic.class);
        configuration.addAnnotatedClass(ProductHousing.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        ProductRepository repository = new ProductRepository(sessionFactory);

        ProductHousing productHousing = ProductHousing.builder().name("producthousing").price(120).width(140).height(170).build();
        ProductFood productFood = ProductFood.builder().name("ProductFood").price(2).expiryDate(LocalDate.now()).build();
        ProductFood productFood2 = ProductFood.builder().name("ProductFood").price(2).expiryDate(LocalDate.now()).build();
        ProductElectronic productElectronic = ProductElectronic.builder().name("productElec").price(400).batterieDuration(50).build();

        repository.saveOrUpdate(productElectronic);
        repository.saveOrUpdate(productFood2);
        repository.saveOrUpdate(productFood);
        repository.saveOrUpdate(productHousing);

        System.out.println(repository.get());

        System.out.println(repository.getProductByType(ProductClass.FOOD, ProductFood.class));

        System.out.println(repository.get(1));


    }
}