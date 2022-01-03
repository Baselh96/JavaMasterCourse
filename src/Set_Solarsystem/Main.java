package Set_Solarsystem;

import java.util.*;

public class Main {
    private static  final Map<HeavenlyBody.Key, HeavenlyBody> solarsystem = new HashMap<>();
    private static final Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);
        HeavenlyBody tempMoon = new Moon("Moon", 28);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);
        tempMoon = new Moon("Deimos", 1.3);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Phobos", 0.3);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Deimos", 1.3);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        System.out.println(temp.addSatellite(tempMoon));


        temp = new Planet("Jupiter", 4332);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);
        tempMoon = new Moon("Io", 1.8);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Europa", 3.5);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Ganymede", 7.1);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Callisto", 16.7);
        solarsystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);


        temp = new Planet("Pluto", 248);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarsystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Alle Planets:");
        for( HeavenlyBody planet : planets){
            System.out.println("\t"+ planet);
        }

        HeavenlyBody body = solarsystem.get(new HeavenlyBody.Key("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " +body.getKey().getName());
        for (HeavenlyBody moon: body.getSatellites()){
            System.out.println("\t"+moon.getKey().getName() +"\t"+ moon.hashCode());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet: planets){
            moons.addAll(planet.getSatellites());
        }
        System.out.println("Alle Moons :");
        for(HeavenlyBody planet: moons){
            System.out.println("\t"+planet);
        }


    }
}
