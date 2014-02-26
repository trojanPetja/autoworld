package be.vdab.voertuigen.div;

import java.io.Serializable;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {

    private final String plaat;

    Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    /**
     * @return the plaat
     */
    public String getPlaat() {
        return plaat;
    }

    @Override
    public String toString() {
        return plaat;
    }

    @Override
    public int hashCode() {
        String ss = plaat.substring(3);
        return Integer.parseInt(ss);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nummerplaat) {
            Nummerplaat nr = (Nummerplaat) obj;
            return plaat.equals(nr.plaat);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Nummerplaat obj) {
        return this.plaat.compareTo(obj.plaat);
    }
}
