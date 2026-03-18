package org.example.Creational.Factory.VehicleObject;

import org.example.Creational.Factory.Vehicle;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Conduire une voiture !!!");
    }
}
