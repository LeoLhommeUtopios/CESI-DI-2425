package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class IHMCustomer {

    private final Scanner sc;

    private final CustomerService customerService;

    public IHMCustomer(Scanner sc) {
        this.sc = sc;
        customerService = new CustomerService();
    }

    public void start (){
        String entry;
        while (true){
            System.out.println(" --- Customer gestion ---");
            System.out.println("1/ create Customer");
            System.out.println("2/ update Customer");
            System.out.println("3/ delete Customer");
            System.out.println("4/ find Customer by id");
            System.out.println("5/ find all Customer");
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
        System.out.println("--- create customer ---");
        System.out.println("firstname :");
        String firstname = sc.nextLine();
        System.out.println("lastname :");
        String lastname = sc.nextLine();
        System.out.println("email :");
        String email = sc.nextLine();

        customerService.create(firstname,lastname,email);
    }


    private void update (){

    }

    private void delete (){

    }

    private void findById (){
        System.out.println("find Customer");
        System.out.println("id :");
        int id = sc.nextInt();
        sc.nextLine();
        Customer customer = customerService.findById(id);
        System.out.println(customer);
    }

    private void findAll (){
        System.out.println("find all customer :");
        List<Customer> customers = customerService.findAll();
        customers.forEach(System.out::println);
    }
}
