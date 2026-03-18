package org.example.ExoComposite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addSubordinate(Employee employee){
        subordinates.add(employee);
    }

    @Override
    public void showDetail(String space) {
        System.out.println(space+"Manager :"+name);
        for (Employee employee : subordinates){
            employee.showDetail(space+"   ");
        }
    }
}
