package org.example.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component{
    private String name;
    private List<Component> content = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Component component){content.add(component);}

    @Override
    public void operation() {
        System.out.println("Dossier : "+name);
        for (Component c : content){
            c.operation();
        }
    }
}
