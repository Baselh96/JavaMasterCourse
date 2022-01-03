package Sitzplatzresavierungssystem;

public class Person {
    private String name;
    private String vorname;
    private String geburtsdatum;
    private int sitzplatz;

    public Person(String name, String vorname, String geburtsdatum){
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setSitzplatz(int sitzplatz) {
        this.sitzplatz = sitzplatz;
    }

    public int getSitzplatz() {
        return sitzplatz;
    }
}
