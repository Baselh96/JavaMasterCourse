package MobilePhoneApp;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone liste = new MobilePhone("01234567");

    public static void main(String[] args){
        boolean test = true;
        mobilstart();
        akions();
        while (test){
            System.out.println("Geben Sie bitte die Nummer ein: ");
            int number = scanner.nextInt();
            switch (number){
                case 0: akions(); break;
                case 1: liste.printContact(); break;
                case 2: einfuegen(); break;
                case 3: aendern(); break;
                case 4: loeschen(); break;
                case 5: suchen(); break;
                case 6: liste.clearContacts(); break;
                case 7: test = false;
            }
        }
    }
    public static void mobilstart(){
        System.out.println("Mobile starting...");
    }
    public static void akions(){
        System.out.println("Wählen Sie eine Nummer: \n");
        System.out.println("0. zurück zum Menü.");
        System.out.println("1. Ausgeben aller Kontakte.");
        System.out.println("2. Einfügen eines neuen Kontakts.");
        System.out.println("3. Ändern eines Kontakts.");
        System.out.println("4. Löschen eines Kontakts.");
        System.out.println("5. Suchen nach einem Element.");
        System.out.println("6. Clear der Liste.");
        System.out.println("7. Programm beenden");
    }
    public static void einfuegen(){
        System.out.println("Geben Sie bitte den Namen ein: ");
        String name = scanner.next();
        System.out.println("Geben Sie bitte die Nummer ein: ");
        String nummer = scanner.next();
        liste.addNewContact(Contact.createContact(name, nummer));
    }
    public static void aendern(){
        System.out.println("Geben Sie bitte den zu änderende Namen ein: ");
        String oldname = scanner.next();
        Contact old = liste.queryContact(oldname);
        if(old == null){
            System.out.println("der Kontakt mit Namen "+ oldname + " existiert nicht");
            return;
        }
        System.out.println("Geben Sie bitte den zu neuen Namen ein: ");
        String newname = scanner.next();
        System.out.println("Geben Sie bitte die neue Nummer ein: ");
        String newnummer = scanner.next();
        liste.updateContact(old, Contact.createContact(newname, newnummer));
    }
    public static void loeschen(){
        System.out.println("Geben Sie bitte den Namen ein: ");
        String name = scanner.next();
        Contact old = liste.queryContact(name);
        if(old == null){
            System.out.println("der Kontakt mit Namen "+ name + " existiert nicht");
            return;
        }
        liste.removeContact(old);
    }
    public static void suchen(){
        System.out.println("Geben Sie bitte den Namen ein: ");
        String name = scanner.next();
        if(liste.queryContact(name) != null){
            System.out.println(name + " wurde gefunden!");
        }else System.out.println(name + " wurde nicht gefunden!");
    }
}
