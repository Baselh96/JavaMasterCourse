package Map_Mapgame;

import java.util.HashMap;
import java.util.Map;

public class Mapprogram {
    public static void main(String[] args) {
        Map<String, String> language = new HashMap<>();
        language.put("SQL", " eine Datenbanksprache, um die Daten in relationale DBMS zu speichern. ");
        language.put("Java", "eine objektorientierte Sprache mit vielen Featurs.");
        language.put("Kotlin", "eine objektorientierte Sprache mit vielen Featurs und mit der kann man Android-Anwendungen erstellen");

        language.forEach((s,w)-> System.out.println(s + ": "+ w ));
        for(String key : language.keySet()){
            System.out.println(key + ": "+ language.get(key));
        }

    }
}
