package Banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public boolean newCustomer(String customername, double transaction){
        if(findCustomer(customername) == null){
            customers.add(new Customer(customername, transaction));
            return true;
        }
        return false;
        /*for (int i = 0; i < customers.size(); i++){
            if( customers.get(i).getName().equals(customername)){
                return false;
            }
        }
        customers.add(new Customer(customername, transaction));
        return true;
        */

    }

    public boolean addCustomerTransaction(String customername, double transaction){
        if(findCustomer(customername) != null){
            findCustomer(customername).addTransaction(transaction);
            return true;
        }
        /*for (int i = 0; i < customers.size(); i++){
            if( customers.get(i).getName().equals(customername)){
                customers.get(i).addTransaction(transaction);
                return true;
            }
        }*/
        return false;
    }
    private Customer findCustomer( String name){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().equals(name)){
                return customers.get(i);
            }
        }
        return null;
    }

}
