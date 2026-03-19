package org.example.ExoBuilder;

public class ModernHouseBuilder implements HouseBuilder{
    private House house = new House();

    @Override
    public void SetFloors(int floors) {
        house.setFloors(floors);
    }

    @Override
    public void setRoofType(String roofType) {
        house.setRoofType(roofType);
    }

    @Override
    public void setHasPool(boolean hasPool) {
        house.setHasPool(hasPool);
    }

    @Override
    public House BuildHouse() {
        return house;
    }
}
