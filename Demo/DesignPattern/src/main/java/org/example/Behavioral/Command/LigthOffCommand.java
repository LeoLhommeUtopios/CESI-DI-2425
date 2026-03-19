package org.example.Behavioral.Command;

public class LigthOffCommand implements Command{

    private Light light;

    public LigthOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
