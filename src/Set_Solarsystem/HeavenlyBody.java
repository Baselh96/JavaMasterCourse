package Set_Solarsystem;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;
    public enum BodyTypes {PLANET, DWARF_PLANET, MOON}

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        satellites = new HashSet<>();
        this.key = makeKey(name, bodyType);
    }
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public Key getKey() {
        return key;
    }
    public boolean addSatellite(HeavenlyBody satellite){
        return satellites.add(satellite);
    }
    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }
    @Override
    public final boolean equals(Object o) {
        if(this == o) return true;
        return this.key.equals(((HeavenlyBody) o).getKey());
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }
    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name, bodyTypes);
    }

    @Override
    public String toString() {
        return key.toString()+", "+ orbitalPeriod;
    }

    public static final class Key{
        private final String name;
        private final BodyTypes bodyType;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Key){
                return this.name.equals(((Key)o).getName()) && this.bodyType == ((Key)o).getBodyType();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }

        @Override
        public String toString() {
            return this.name + ": "+ this.bodyType;
        }
    }
}
