package org.example.ExoBuilder;

import java.security.cert.TrustAnchor;

public class Main {
    public static void main(String[] args) {
        HouseBuilder builderModern = new ModernHouseBuilder();
        builderModern.SetFloors(2);
        builderModern.setRoofType("Flat");
        builderModern.setHasPool(true);
        House house1 = builderModern.BuildHouse();
        System.out.println(house1);

        HouseBuilder builderTrad = new TradHouseBuilder();
        builderTrad.SetFloors(3);
        builderTrad.setRoofType("Flat");
        builderModern.setHasPool(false);
        House house2 = builderTrad.BuildHouse();
        System.out.println(house2);
    }
}
