package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import static be.vdab.util.mens.Rijbewijs.*;
import be.vdab.voertuigen.div.Nummerplaat;
import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections.CollectionUtils;

public class Personenwagen extends Voertuig implements Serializable,Comparable<Voertuig> {

    private Color kleur;

    public Personenwagen(String merk, Datum d, int prijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... persoon) throws MensException, IllegalArgumentException {

        super(merk, d, prijs, zitplaatsen, bestuurder, persoon);
        this.kleur = kleur;
        if (zitplaatsen > 8) {
            throw new IllegalArgumentException();
        }
    }
 public void setKleur(Color clr) {

        this.kleur = clr;
    }
    public Color getKleur() {
        return kleur;
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
    public void setAankoopprijs(int price){
    
        super.setAankoopprijs(price);
    }
    @Override
    public Nummerplaat getNummerplaat(){
    return super.getNummerplaat();
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
    public int compareTo(Voertuig v) {
    return super.compareTo(v);
    }
    
    @Override
    public boolean equals(Object obj){
        
        if (obj instanceof Personenwagen){
    
    Personenwagen v = (Personenwagen) obj;
       return super.equals(v);}
       else
       return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.kleur)+super.hashCode();
        return hash;
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        Rijbewijs []b= {B};
        return b;
    }
 
   
    
    @Override
    public String toString(){
    return super.toString()+" "+Integer.toString(zitplaatsen);
    }
    
    

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return 8;
    }
}


