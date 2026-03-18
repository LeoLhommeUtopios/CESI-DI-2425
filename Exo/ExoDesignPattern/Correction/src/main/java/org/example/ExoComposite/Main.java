package org.example.ExoComposite;

public class Main {

    public static void main(String[] args) {
        Manager manager1 = new Manager("Manager1");
        Manager manager2 = new Manager("Manager2");
        Manager manager3 = new Manager("Manager3");

        Employee employee1 = new IndividualEmployee("Employee1");
        Employee employee2 = new IndividualEmployee("Employee2");
        Employee employee3 = new IndividualEmployee("Employee3");
        Employee employee4 = new IndividualEmployee("Employee4");
        Employee employee5 = new IndividualEmployee("Employee5");

        manager1.addSubordinate(employee1);
        manager1.addSubordinate(employee2);

        manager3.addSubordinate(employee3);
        manager3.addSubordinate(employee4);

        manager2.addSubordinate(employee5);

        manager1.addSubordinate(manager3);

        manager2.addSubordinate(manager1);

        manager2.showDetail("");
    }
}
