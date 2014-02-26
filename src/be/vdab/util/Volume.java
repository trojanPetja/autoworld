package be.vdab.util;

import java.io.Serializable;
import static java.lang.Long.signum;
import java.util.Objects;

public final class Volume implements Comparable<Volume>, Serializable {

    private final int hoogte, breedte, diepte;
    private final Maat maat;
    private long volume;

    public Volume(int hoogte, int breedte, int diepte, Maat maat) throws VolumeException {
        if (hoogte >= 0 && breedte >= 0 && diepte >= 0) {
            this.breedte = breedte;
            this.diepte = diepte;
            this.hoogte = hoogte;
            this.maat = maat;
        } else {
            throw new VolumeException();
        }

    }

    public long getVolume() {
        this.volume = maat.get3DVerhouding() *this.breedte * this.diepte * this.hoogte;
        return this.volume;
    }

    public int getBreedte() {
        return this.breedte;
    }

    public int getHoogte() {
        return this.hoogte;
    }

    public int getDiepte() {
        return this.diepte;
    }

    public Maat getMaat() {
        return this.maat;
    }

    @Override
    //een object is groter of kleiner dan een ander object als zijn volume groter of kleiner is. 
    public int compareTo(Volume v) {
        return new Long(getVolume()).compareTo(v.getVolume());
    }

    //Twee objecten zijn aan elkaar gelijk asa de drie afmetingen ervan (breedte, hoogte, diepte) ook gelijk zijn. 
    @Override
    public boolean equals(Object obj) {

        //de nullwaarde wordt standaard als false getagd                       
        if (obj instanceof Volume) {
            Volume v = (Volume) obj;
            if (this.maat.equals(v.maat)) {
                return (this.breedte == v.breedte && this.diepte == v.diepte && this.hoogte == v.hoogte);
            } else if (this.maat.equals("centimeter") && v.maat.equals("decimeter")) {
                return (this.breedte / 10) == v.breedte;
            } else if (this.maat.equals("decimeter") && v.maat.equals("centimeter")) {
                return (v.breedte / 10) == this.breedte;
            } else if (this.maat.equals("decimeter") && v.maat.equals("meter")) {
                return (this.breedte / 10) == v.breedte;
            } else if (this.maat.equals("meter") && v.maat.equals("decimeter")) {
                return (v.breedte / 10) == this.breedte;
            } else if (this.maat.equals("centimeter") && v.maat.equals("meter")) {
                return this.breedte == (v.breedte * 100);
            } else if (this.maat.equals("meter") && v.maat.equals("centimeter")) {
                return v.breedte == (this.breedte * 100);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
@Override
    public String toString() {

        return this.hoogte + "(h)x" + this.breedte + "(b)x" + this.diepte + "(d) " + this.maat;

    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.hoogte;
        hash = 19 * hash + this.breedte;
        hash = 19 * hash + this.diepte;
        hash = 19 * hash + Objects.hashCode(this.maat);
        return hash;
    }
/**
    private int centToDecim(Volume v) {
        return signum(this.volume / (10 ^ 3) - v.volume);
    }

    private int decimToMeter(Volume v) {
        return signum(this.volume / (10 ^ 3) - v.volume);
    }

    private int centToMeter(Volume v) {
        return signum(this.volume / (10 ^ 6) - v.volume);
    }

   */ 
}
