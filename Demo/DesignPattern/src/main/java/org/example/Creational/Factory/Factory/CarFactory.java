package org.example.Creational.Factory.Factory;

import org.example.Creational.Factory.Vehicle;
import org.example.Creational.Factory.VehicleObject.Car;
import org.example.Creational.Factory.VehicleObject.Truck;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
