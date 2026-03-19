package org.example.ExoBuilder;

public interface HouseBuilder {
    void SetFloors (int floors);
    void setRoofType(String roofType);
    void setHasPool(boolean hasPool);
    House BuildHouse ();
}
