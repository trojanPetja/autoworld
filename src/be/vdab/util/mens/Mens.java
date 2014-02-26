package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Mens implements Comparable<Mens>, Serializable {

    private String naam;
    Set<Rijbewijs> rijbewijzen = new LinkedHashSet<>();

    public Mens(String naam, Rijbewijs... rb) {
        this.naam = naam;
        rijbewijzen.addAll(Arrays.asList(rb));
    }

    public String getNaam() {

        return this.naam;
    }

    public Rijbewijs[] getRijbewijs() {

        return rijbewijzen.toArray(new Rijbewijs[0]);
    }

    @Override
    public String toString() {
        if (rijbewijzen.isEmpty() && !this.naam.equals(null)) {
            return this.naam;
        } else {
            Rijbewijs[] nieuw = getRijbewijs();
            String newstring = this.naam + "(" + nieuw[0];

            for (int i = 1; i < nieuw.length; i++) {

                newstring = newstring + ", " + nieuw[i];
            }
            return newstring + ")";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Mens) {
            Mens m = (Mens) obj;
            if (this.naam.equals(m.naam) && this.rijbewijzen.equals(m.rijbewijzen)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.naam);
        hash = 23 * hash + Objects.hashCode(this.rijbewijzen);
        return hash;
    }

    @Override
    public int compareTo(Mens m) {
        return naam.compareTo(m.naam);
    }

}
