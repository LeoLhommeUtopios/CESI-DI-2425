package org.example.Util;

import org.example.Service.BilletService;
import org.example.Service.CustomerService;
import org.example.Service.EventService;
import org.example.model.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private final Scanner scanner;
    private final  CustomerService customerService;
    private final EventService eventService;
    private  final BilletService billetService;

    public Ihm() {
        scanner = new Scanner(System.in);
        customerService = new CustomerService();
        eventService = new EventService();
        billetService = new BilletService(eventService,customerService);
    }

    public void start (){
        init();
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            try{
                switch (entry){
                    case "1"-> addBillet();
                    case "2"->addUser();
                    case "3"-> addBillet();
                    default-> {
                        return;
                    }
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }


    }

    private void init (){

        Address address = new Address("200 rue des lillas","lille");
        Place place = new Place("rue de l'evenement","lille",800);

        Customer customer = new Customer("toto","tata",address,30,"01234567899");
        Customer customer2 = new Customer("titi","tutu",address,30,"01234567899");

        Event event = new Event("Event1",place, LocalDateTime.now(),400);

        customerService.addCustomer(customer);
        customerService.addCustomer(customer2);
        eventService.addEvent(event);
    }

        private void afficheMenu (){
        System.out.println("""
                --- Menu  ---
                1/cree Customer
                2/cree un event
                3/creation d'un billet
                2/aficher les billets d'un client
                3/ afficher les billets d'un event
                """);
    }



    private void addBillet (){
        System.out.println("--- ajout d'un billet ---");

        System.out.println("index du client :");
        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("index de l'evenement :");
        int indexEvent = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Type de la place Standard/ gold / vip");
        String typePlace = scanner.nextLine();
        PlaceTYpe placeTYpe = PlaceTYpe.valueOf(typePlace.toUpperCase());

        Billet billet = null;
        try{
            billet = billetService.addBillet(indexClient,indexEvent,placeTYpe);
        }catch (NotFoundException | EventFullException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(billet);



    }

    private void addUser(){
        System.out.println("--- ajout d'un Client ---");

        System.out.println("Nom  :");
        String lastname = scanner.nextLine();

        System.out.println("Prenom :");
        String firstname = scanner.nextLine();

        System.out.println("Rue :");
        String street = scanner.nextLine();

        System.out.println("Ville :");
        String city = scanner.nextLine();

        System.out.println("Age :");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Telephone :");
        String phone = scanner.nextLine();

        customerService.addCustomer(firstname,lastname,new Address(street,city),age,phone);
        System.out.println("Utilisateur crée");
    }
//
    private void addEvent(){
        System.out.println("--- ajout d'un Evenement ---");

        System.out.println("Nom de l'evenement  :");
        String eventName = scanner.nextLine();

        System.out.println("Rue :");
        String street = scanner.nextLine();

        System.out.println("Ville :");
        String city = scanner.nextLine();

        System.out.println("Capacité max de la salle :");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Date et heure de l'evenement (dd-MM-yyyy hh:mm) ");
        String dateTime = scanner.nextLine();


        System.out.println("Nombre de place  :");
        int numberOfPlace = scanner.nextInt();
        scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);

        eventService.addEvent(eventName,new Place(street,city,capacity),localDateTime,numberOfPlace);
        System.out.println("Event crée");
    }




}
