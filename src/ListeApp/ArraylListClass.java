package ListeApp;
import java.util.ArrayList;

public class ArraylListClass<T> {
    private ArrayList<T> liste = new ArrayList<T>();

    public void printList(){
        System.out.println("Es sind "+ liste.size() +" Elemente vorhanden");
        for(int i = 0; i < liste.size(); i++){
            System.out.println((i+1) + ". "+ liste.get(i));
        }
    }
    public void addItem(T item){
        liste.add(item);
        System.out.println("Die Zeile für "+ item + " ist eingefügt." );
    }
    public void setItem(T item, T newItem){
        int index = liste.indexOf(item);
        if(index >= 0){
            liste.set(index, newItem);
            System.out.println(item + " wurde zu "+ newItem+ " geändert.");
        }else {
            System.out.println(item + " wurde nicht gefunden.");
        }
    }
    public void removeItem(T item){
        if(liste.contains(item)){
            liste.remove(item);
            System.out.println(item + " wurde gelöscht.");
        }else {
            System.out.println(item + " wurde nicht gefunden.");
        }
    }
    public void searchItem(T item){
        if(liste.contains(item)){
            System.out.println(item + " wurde gefunden.");
        }else{
            System.out.println(item + " wurde nicht gefunden.");
        }
    }
    public void clearList(){
        liste.clear();
    }
}
