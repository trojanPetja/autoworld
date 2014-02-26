package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import static be.vdab.util.mens.Rijbewijs.C;
import be.vdab.voertuigen.div.Nummerplaat;
import java.awt.Color;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;


public class Pickup extends Personenwagen implements Laadbaar, Serializable, Comparable<Voertuig> {
    private Volume laadvolume;
//Pickup("a", datum, 100, GETAL4, KLEUR, VOLUME10,BESTUURDER_BBECCE)
    public Pickup(String merk, Datum d, int prijs, int zitplaatsen, Color kleur,Volume vol, Mens bestuurder, Mens... persoon) throws MensException, IllegalArgumentException {
        super(merk, d, prijs, zitplaatsen, kleur, bestuurder, persoon);
        laadvolume = vol;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public void setLaadvolume(Volume v) {
        this.laadvolume=v;
    }
    
    @Override
    public void setKleur(Color clr) {

        super.setKleur(clr);
    }
    
    @Override
    public Color getKleur() {
        return super.getKleur();
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
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        Rijbewijs [] c = {C};
        return c;
    }
    
    
    
    @Override
    public int hashCode(){
    
    int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.laadvolume);
    return super.hashCode()+hash;
    
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof Pickup){
    
    Pickup p = (Pickup) obj;
       return super.equals(p);}
       else
       return false;
    }

    
    @Override
    public String toString(){
    
    return super.toString()+" "+this.laadvolume.toString();
    
    }
      
}





