package org.example.ExoBuilder;

public class House {
    private int floors;
    private String roofType;
    private boolean hasPool;

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", roofType='" + roofType + '\'' +
                ", hasPool=" + hasPool +
                '}';
    }
}
