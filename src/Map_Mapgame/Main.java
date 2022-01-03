package Map_Mapgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExits = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", new HashMap<>()));

        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        Map<String, String > vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("WEST", "W");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        int loc = 1;
        while( true ){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) break;
            Map<String , Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for( String key : exits.keySet() ){
                System.out.print(key + ", ");
            }
            System.out.println();
            String diration = scanner.nextLine().toUpperCase();
            if(diration.length() > 1) {
                String[] words = diration.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        diration = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(!exits.containsKey(diration)){
                System.out.println("You cannot go in that direction");
            }else{
                loc = exits.get(diration);
            }
        }
    }
}
