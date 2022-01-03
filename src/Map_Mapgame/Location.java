package Map_Mapgame;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int loactionID;
    private final String description;
    private final Map<String, Integer > exits;

    public Location(int loactionID, String description, Map<String , Integer> exits) {
        this.loactionID = loactionID;
        this.description = description;
        if(exits == null){
            this.exits = new HashMap<>();
        }else{
            this.exits = new HashMap<>(exits);
        }
        this.exits.put("Q", 0);
    }

 /*   public void addExit(String  direction, int location){
        this.exits.put(direction, location);
    }*/
    public int getLoactionID() {
        return this.loactionID;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(this.exits);
    }
}
