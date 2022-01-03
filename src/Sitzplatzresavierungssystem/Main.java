package Sitzplatzresavierungssystem;

public class Main {
    public static void main(String[] args) {
        Person basel = new Person("Hussein", "Basel", "06.01.1996");
        Person asd = new Person("Abc", "Asd", "06.01.1996");
        Person kaled = new Person("Abcd", "Kaled", "06.01.1996");
        Person julian = new Person("Abcde", "Julian", "06.01.1996");
        Person megail = new Person("Abcdef", "megail", "06.01.1996");
        Sitzplat sitzplatz = new Sitzplat(4, "KinoXY", "FilmXY");
        sitzplatz.reservieren(basel);
        sitzplatz.reservieren(asd);
        sitzplatz.reservieren(megail);
        sitzplatz.reservieren(kaled);
        sitzplatz.stornieren(basel);
        sitzplatz.reservieren(julian);

        System.out.println(sitzplatz.verfügbarePlatze());
        sitzplatz.getsitzPlatz();
        sitzplatz.ausgebenDerListe();
    }
}
