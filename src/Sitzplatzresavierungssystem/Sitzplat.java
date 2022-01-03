package Sitzplatzresavierungssystem;

import java.util.ArrayList;

public class Sitzplat {
    private final String kinoName;
    private final String filmName;
    private final int anzahlDerSitzplaetze;
    private int currentNumber = 0;
    private ArrayList<Person> personen = new ArrayList<>();
    private ArrayList<Integer> storniertePlatze = new ArrayList<>();

    public Sitzplat(int anzahlDerSitzplaetze, String kinoName, String filmName) {
        this.anzahlDerSitzplaetze = anzahlDerSitzplaetze;
        this.kinoName = kinoName;
        this.filmName = filmName;
    }

    public int getsitzPlatz() {
        if(currentNumber <= anzahlDerSitzplaetze){
            System.out.println("Es gibt den Platz  mit der Nummer "+(currentNumber+1)+" zur Verfügung");
            return currentNumber +1;
        }else if( storniertePlatze.size() > 0){
            System.out.println("Es gibt den Platz  mit der Nummer "+(storniertePlatze.get(0))+" zur Verfügung");
            return storniertePlatze.get(0);
        }else{
            System.out.println("Es gibt leider keine Plätze mehr");
            return 0;
        }
    }
    public int verfügbarePlatze() {
        int verfuegabreAnzahl =  anzahlDerSitzplaetze - currentNumber;
        verfuegabreAnzahl += storniertePlatze.size();
        return verfuegabreAnzahl;
    }
    public boolean reservieren( Person person) {
        if(verfügbarePlatze() > 0){
            personen.add(person);
            if(anzahlDerSitzplaetze - (currentNumber) > 0) {
                person.setSitzplatz(++currentNumber);
            }else{
                person.setSitzplatz(storniertePlatze.get(0));
                storniertePlatze.remove(0);
            }
            System.out.println("Der Sitzplatz "+person.getSitzplatz()+" wurde für "+ person.getVorname() +" " + person.getName() +" reservert.");
            return true;
        }else{
            System.out.println("Es gibt leider keine freie Platze mehr!");
            return false;
        }
    }
    public void ausgebenDerListe(){
        for( Person p : personen){
            System.out.println("Der Sitzplatz "+ p.getSitzplatz() +" ist für Person "+ p.getVorname() + " "+ p.getName()+ " reserviert.");
        }
    }

    public boolean stornieren( Person person){
        if(personen.contains(person)){
            storniertePlatze.add(person.getSitzplatz());
            personen.remove(person);
            System.out.println("Der Sitzplatz "+ person.getSitzplatz()+ " für Person "+ person.getVorname()+ " "+ person.getName() + " wurde störniert.");
            return true;
        }else{
            System.out.println("Der Sitzplatz "+ person.getSitzplatz()+ " für Person "+ person.getVorname()+ " "+ person.getName() + " gibt es nicht.");
            return false;
        }
    }


}
