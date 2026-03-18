package org.example.Creational.Factory;

import org.example.Creational.Factory.Factory.CarFactory;
import org.example.Creational.Factory.Factory.TruckFactory;
import org.example.Creational.Factory.Factory.VehicleFactory;

public class main {
    public static void main(String[] args) {
        VehicleFactory carfactory = new CarFactory();
        Vehicle car = carfactory.createVehicle();
        car.drive();

        VehicleFactory truckFactory = new TruckFactory();
        Vehicle truck = truckFactory.createVehicle();
        truck.drive();
    }
}
