package org.example.Creational.Factory.VehicleObject;

import org.example.Creational.Factory.Vehicle;

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Conduire un camion !!");
    }
}
