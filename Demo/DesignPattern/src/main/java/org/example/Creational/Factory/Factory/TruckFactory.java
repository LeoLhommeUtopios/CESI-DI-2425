package org.example.Creational.Factory.Factory;

import org.example.Creational.Factory.Vehicle;
import org.example.Creational.Factory.VehicleObject.Truck;

public class TruckFactory extends VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
