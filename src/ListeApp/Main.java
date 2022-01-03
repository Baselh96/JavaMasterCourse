package ListeApp;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static ArraylListClass<Integer> liste = new ArraylListClass<>();
    public static void main(String[] args){
        boolean test = true;
        menu();
        while (test){
            System.out.println("Geben Sie bitte die Nummer ein: ");
            int number = scanner.nextInt();
            switch (number){
                case 0: menu(); break;
                case 1: liste.printList(); break;
                case 2: einfuegen(); break;
                case 3: aendern(); break;
                case 4: loeschen(); break;
                case 5: suchen(); break;
                case 6: liste.clearList(); break;
                //case 8: Collections.sort(liste); break;

                case 7: test = false;
            }
        }
    }
    public static void menu(){
        System.out.println("Wählen Sie eine Nummer: \n");
        System.out.println("0. zurück zum Menü.");
        System.out.println("1. Ausgeben aller Elemente.");
        System.out.println("2. Einfügen eines neuen Element.");
        System.out.println("3. Ändern eines Elements.");
        System.out.println("4. Löschen eines Elements.");
        System.out.println("5. Suchen nach einem Element.");
        System.out.println("6. Clear der Liste.");
        System.out.println("7. sortieren der Liste.");
        System.out.println("7. Programm beenden");
    }
    public static void einfuegen(){
        System.out.println("Geben Sie bitte das Element ein: ");
        int item = scanner.nextInt();
        liste.addItem(item);
    }
    public static void aendern(){
        System.out.println("Geben Sie bitte das zu ändernde Element ein: ");
       int item = scanner.nextInt();
        System.out.println("Geben Sie bitte das neue Element ein: ");
        int newItem = scanner.nextInt();
        liste.setItem(item,newItem);
    }
    public static void loeschen(){
        System.out.println("Geben Sie bitte das zu löschende Element ein: ");
        int item = scanner.nextInt();
        liste.removeItem(item);
    }
    public static void suchen(){
        System.out.println("Geben Sie bitte das zu suchende Element ein: ");
        int item = scanner.nextInt();
        liste.searchItem(item);
    }
}
