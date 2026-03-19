package org.example.Behavioral.Command;

public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton (){
        if(command !=null){
            command.execute();
        }else{
            System.out.println("Aucune commande assigné a ce bouton");
        }
    }
}
