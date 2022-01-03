package MobilePhoneApp;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<Contact>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        //myContacts.add(new Contact("my", myNumber));
    }
    public boolean addNewContact( Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Der Kontakt mit dem Namen "+ contact.getName() + " existiert!!");
            return false;
        }else{
            myContacts.add(contact);
            System.out.println("Der Kontakt mit dem Namen "+ contact.getName() + " wurde eingefügt");
            return true;
        }
    }
    public boolean updateContact( Contact oldcontact, Contact newcontact){
        int index = findContact(oldcontact);
        if(index >= 0){
            if(queryContact(newcontact.getName()) != null){
                System.out.println("Der Kontakt mit dem Namen "+ newcontact.getName() + " existiert schon!!");
                return false;
            }
            System.out.println("Der Kontakt mit dem Namen "+ oldcontact.getName() + " wurde geändert!!");

            myContacts.set(index, newcontact);
            return true;
        }else{
            System.out.println("Der Kontakt mit dem Namen "+ oldcontact.getName() + " existiert nicht!!");
            return false;
        }
    }
    public boolean removeContact( Contact contact){
        if(findContact(contact) >= 0){
            myContacts.remove(contact);
            System.out.println("Der Kontakt mit dem Namen "+ contact.getName() + " wurde gelöscht!!");
            return true;
        }else{
            System.out.println("Der Kontakt mit dem Namen "+ contact.getName() + " existiert nicht!!");
            return false;
        }
    }
    private int findContact( Contact contact){
        return findContact(contact.getName());
    }
    private int findContact( String s){
        for(int i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).getName().equals(s) ) return i;
        }
        return -1;
    }
    public Contact queryContact(String s){
        if(findContact(s) >= 0){
            return myContacts.get(findContact(s));
        }else return null;
    }
    public void printContact(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.println((i+1) + " " + myContacts.get(i).getName() + " -> "+ myContacts.get(i).getPhoneNumber());
        }
    }
    public void clearContacts(){
        myContacts.clear();
    }
}
