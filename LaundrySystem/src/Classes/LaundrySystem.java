package Classes;

import java.util.ArrayList;

public class LaundrySystem {

    private ArrayList<Customer> Customers;

    public LaundrySystem() {
        Customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        Customers.add(customer);
    }
    
    public ArrayList<Customer> allCustomers(){
        return Customers;
    } 

}