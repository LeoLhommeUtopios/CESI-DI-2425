package org.example.Service;

import org.example.Util.NotFoundException;
import org.example.model.Address;
import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> customers ;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String firstname, String lastname, Address address,int age,String phone){
        customers.add(new Customer(firstname,lastname,address,age,phone));
    }

    public void addCustomer (Customer customer){
        customers.add(customer);
    }

    public List<Customer> getAllCustomùer (){
        return customers;
    }

    public boolean deleteCustomer (int index){
        try{
            customers.remove(index);
            return true;
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }

    public Customer getById (int index){
        try{
            return customers.get(index);
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }

    public Customer update (int index, String firstname, String lastname, Address address,int age,String phone){
        try{
            Customer customerFound = customers.get(index);
            customerFound.setFirstName(firstname);
            customerFound.setLastName(lastname);
            customerFound.setAddress(address);
            customerFound.setTelephone(phone);
            customerFound.setAge(age);
            return customerFound;
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }
}
