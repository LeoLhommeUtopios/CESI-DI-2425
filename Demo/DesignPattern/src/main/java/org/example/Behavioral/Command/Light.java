package org.example.Behavioral.Command;

public class Light {

    private boolean isOn = false;

    public void turnOn (){
        if(!isOn){
            System.out.println("Lumiere allumé");
            isOn = true;
        }
    }

    public void turnOff (){
        if(isOn){
            System.out.println("Lumiere eteinte");
            isOn = false;
        }
    }
}
