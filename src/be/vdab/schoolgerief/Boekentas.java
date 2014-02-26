package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author vera.baikova
 */
public class Boekentas implements Laadbaar, Comparable<Boekentas>, Serializable {

    private Volume laadvolume;
    private String kleur;

    public Boekentas(String kleur, Volume v) throws IllegalArgumentException {

        if (kleur instanceof String && v instanceof Volume) {

            this.kleur = kleur;
            laadvolume = v;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void setKleur(String kleur) {

        if (kleur instanceof String) 

            this.kleur = kleur;
           
        else 
            throw new IllegalArgumentException();

    }

    public String getKleur() {

        return kleur;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    /**
     *
     * @param v
     */
    @Override
    public void setLaadvolume(Volume v) {
        if (v instanceof Volume) 

            this.laadvolume = v;
        else 
            throw new IllegalArgumentException();
        
    }

    @Override
    public int compareTo(Boekentas bt) {
        return this.laadvolume.compareTo(bt.laadvolume);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Boekentas) {
            Boekentas bt = (Boekentas) obj;
            return (this.laadvolume.equals(bt.laadvolume)&&this.kleur.equalsIgnoreCase(bt.kleur));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.laadvolume);
        hash = 83 * hash + Objects.hashCode(this.kleur);
        return hash;
    }
    @Override
    public String toString(){
    return "boekentas "+this.kleur+" "+this.laadvolume.toString();
    
    }
}
