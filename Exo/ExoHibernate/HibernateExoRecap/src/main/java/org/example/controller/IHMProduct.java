package org.example.controller;

import org.example.entity.Customer;
import org.example.entity.product.Product;
import org.example.service.ProductService;
import org.example.service.SellService;
import org.example.utils.Categories;

import java.time.LocalDate;
import java.util.Scanner;

public class IHMProduct {
    private final Scanner sc;

    private final ProductService productService;

    public IHMProduct(Scanner sc) {
        this.sc = sc;
        productService = new ProductService();
    }

    public void start (){
        String entry;
        while (true){
            System.out.println(" --- Stock gestion ---");
            System.out.println("1/ create product");
            System.out.println("2/ update product");
            System.out.println("3/ delete product");
            System.out.println("4/ find product by id");
            System.out.println("5/ find all product");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> create();
                case "2"-> update();
                case "3"-> delete();
                case "4"-> findById();
                case "5"-> findAll();
                default -> {return;}
            }
        }
    }

    private void create (){
        System.out.println(" --- create Product ---");
        System.out.println("1/ ProductCloth");
        System.out.println("2/ ProductFood");
        System.out.println("3/ ProductElectronic");
        String productSelect;
        productSelect = sc.nextLine();

        switch (productSelect){
            case "1"-> createProductCloth();
            case "2"-> createProductFood();
            case "3"-> createProductElectronic();
            default -> {return;}
        }

    }

    private void createProductCloth (){
        System.out.println("""
                --- create a productCloth
                "Description :"
                """);
        String description = sc.nextLine();

        System.out.println("price :");
        float price = sc.nextFloat();

        System.out.println("stock");
        int stock = sc.nextInt();

        System.out.println("size : (xs, s ,m , l xl");
        String size = sc.nextLine();

        int i = 1;
        System.out.println("Categories :");
        for (Categories categories : Categories.values()){
            System.out.println(categories);
        }
        Categories categories = Categories.valueOf(sc.nextLine().toUpperCase());

        productService.createProduct(description,categories,size,price,stock);
    }
    private void createProductFood (){
        System.out.println("--- create a productFood");
        System.out.println("Description");
        String description = sc.nextLine();

        System.out.println("price :");
        float price = sc.nextFloat();

        System.out.println("stock");
        int stock = sc.nextInt();


        productService.createProduct(description,price,stock, LocalDate.ofEpochDay(LocalDate.now().toEpochDay() + 604800000));
    }
    private void createProductElectronic (){
        System.out.println("--- create a productElectronic");
        System.out.println("Description");
        String description = sc.nextLine();

        System.out.println("price :");
        float price = sc.nextFloat();

        System.out.println("stock");
        int stock = sc.nextInt();

        System.out.println("battery duration :");
        int batteryDuration = sc.nextInt();


        productService.createProduct(description,price,stock, batteryDuration);

    }


    private void update (){

    }

    private void delete (){

    }

    private void findById (){
        System.out.println("Find product :");
        System.out.println("id :");
        int id = sc.nextInt();
        sc.nextLine();
        Product product = productService.findById(id);
        System.out.println(product);
    }

    private void findAll (){
        System.out.println("find all product");
        productService.findAll().forEach(System.out::println);
    }
}
