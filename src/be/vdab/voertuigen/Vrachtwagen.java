package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import static be.vdab.util.mens.Rijbewijs.*;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Vrachtwagen extends Voertuig implements Laadbaar,Comparable<Voertuig>, Serializable {

    private Volume laadvolume;
    private int maxToegelatenMassa;
    private int aantalAssen;
// Vrachtwagen("a", datum, AANKOOPPRIJS_1, 4, VOLUME10, MAXIAAM_TOEGELATEN_MASSA_1, AANTAL_ASSEN_2, BESTUURDER_BBECCE,INGEZETENE_A, INGEZETENE_B, INGEZETENE_C))

    public Vrachtwagen(String merk, Datum d, int prijs, int plaatsen, Volume laadvolume, int maxMassa, int assen, Mens bestuurder, Mens... inzittenden) throws MensException, IllegalArgumentException {
        super(merk, d, prijs, plaatsen, bestuurder, inzittenden);
        this.laadvolume = laadvolume;
        maxToegelatenMassa = maxMassa;
        aantalAssen = assen;
        if (zitplaatsen > 3) {
            throw new IllegalArgumentException();
        }
    }

    public int getMaximaalToegelatenMassa() {
        return maxToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int massa) {

        this.maxToegelatenMassa = massa;
    }

    public int getAantalAssen() {

        return aantalAssen;
    }

    public void setAantalAssen(int assen) {

        this.aantalAssen = assen;
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        Rijbewijs [] rij = {C,CE};
        return rij;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public void setLaadvolume(Volume v) {
       this.laadvolume = v;
    }
    
    @Override
    public void setDatumEersteIngebruikname(Datum dat){
    
    super.setDatumEersteIngebruikname(dat);
    
    }
    
    @Override
    public Datum getDatumEersteIngebruikname(){
    
    return super.getDatumEersteIngebruikname();
    }
    
    @Override
    public void setMerk(String merk){
    
        super.setMerk(merk);
    }
    
    @Override
    public String getMerk(){
    return super.getMerk();
    }
    
    
    @Override
    public Nummerplaat getNummerplaat(){
    return super.getNummerplaat();
    }
    
   
    @Override
    public void setAankoopprijs(int price){
    
        super.setAankoopprijs(price);
    }
    
    
    @Override
    public int getAankoopprijs(){
    return
            super.getAankoopprijs();}
    
    @Override
    public int getZitplaatsen(){
    
    return super.getZitplaatsen();
    }
    
   
    
     @Override
    public boolean equals(Object obj) {

        if (obj instanceof Vrachtwagen) {

            Vrachtwagen v = (Vrachtwagen) obj;

            return this.getNummerplaat().equals(v.getNummerplaat());
        } 
        
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.laadvolume);
        hash = 83 * hash + this.maxToegelatenMassa;
        hash = 83 * hash + this.aantalAssen;
        return hash;
    }
    
    @Override
    public String toString(){
    //assen:%s, maximaal toegelaten massa:%s, laadvolume:%
    return super.toString()+" assen:"+ Integer.toString(aantalAssen) +", maximaal toegelaten massa:"+ Integer.toString(this.maxToegelatenMassa) +", laadvolume:"+ this.laadvolume.toString();
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
       return 3;
    }
}
