package org.example.ExoComposite;

public class IndividualEmployee implements Employee{
    private String name;

    public IndividualEmployee(String name) {
        this.name = name;
    }

    @Override
    public void showDetail(String space) {
        System.out.println(space+"Employee : "+name);
    }
}
