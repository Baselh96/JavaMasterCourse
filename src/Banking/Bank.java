package Banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }
    public boolean addBranch( String branchname){
        if(findBranch(branchname) == null){
            branches.add(new Branch(branchname));
            return true;
        }
        return false;
    }
    // ***
    public boolean addCustomer( String branchname, String customername , double transaction){
        Branch newBranch = findBranch(branchname);
        if( newBranch != null){
            return newBranch.newCustomer(customername, transaction);
        }
        return false;
    }
    // **
    public boolean addCustomerTransaction( String branchname, String customername , double transaction){
        Branch newBranch = findBranch(branchname);
        if( newBranch != null){
            return newBranch.addCustomerTransaction(customername, transaction);
        }
        return false;
    }
    private Branch findBranch( String branchname){
        for (int i = 0; i < branches.size(); i++) {
            if(branches.get(i).getName().equals(branchname)){
                return branches.get(i);
            }
        }
        return null;
    }
    public boolean listCustomers( String branchname, boolean transaction){
        Branch newBranch = findBranch(branchname);
        if( newBranch == null) return false;
        ArrayList<Customer> listeC = newBranch.getCustomers();
        System.out.println("Customer details for branch "+ newBranch.getName());
        for(int i = 0; i  < listeC.size(); i++) {
            Customer customer = listeC.get(i);
            System.out.println("Customer: " + customer.getName() + "[" + (i+1)+"]");
            if(transaction) {
                System.out.println("Transactions");
                for (int j = 0; j < customer.getTransactions().size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount " + customer.getTransactions().get(j));
                }
            }
        }
        return true;
    }
/*
    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }

 */
}
