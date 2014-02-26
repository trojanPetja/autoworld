package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections.CollectionUtils;

public abstract class Voertuig implements Comparable<Voertuig>, Serializable {

    protected Nummerplaat nummerplaat;
    protected String merk;
    protected Datum datumEersteIngebruikname;
    protected int aankoopprijs;
    protected final int zitplaatsen;
    protected Mens bestuurder;
    Set<Mens> ingezetenen = new TreeSet<>();

    public Voertuig(String merk, Datum d, int prijs, int plaatsen, Mens bestuurder, Mens... inzittenden) throws MensException, IllegalArgumentException {
        nummerplaat = DIV.getInstance().getNummerplaat();
        this.merk = merk;
        datumEersteIngebruikname = d;
        aankoopprijs = prijs;
        this.bestuurder = bestuurder;
        ingezetenen.add(bestuurder);
        ingezetenen.addAll(Arrays.asList(inzittenden));
        zitplaatsen = plaatsen;
        
        if (ingezetenen.size() <= 0 || plaatsen <= 0) {
            throw new IllegalArgumentException();
        } else if (ingezetenen.size() > plaatsen || bestuurder.getRijbewijs().length == 0 || checkRijbewijs(bestuurder) == false) {
            throw new MensException();
        } 
    }

    protected void setMerk(String merk) {
        this.merk = merk;
    }

    protected void setDatumEersteIngebruikname(Datum date) {
        this.datumEersteIngebruikname = date;
    }

    public void setBestuurder(Mens new_bestuurder) {
        if (ingezetenen.contains(new_bestuurder) && checkRijbewijs(new_bestuurder) == true)
           this.bestuurder = new_bestuurder;
        
        
       else if (this.zitplaatsen <= ingezetenen.size()) {
            throw new MensException();
        } 
     
        else if (checkRijbewijs(new_bestuurder) == true) {

            this.bestuurder = new_bestuurder;
            ingezetenen.add(new_bestuurder);
        }
        else
            throw new MensException();
    }

    public void setAankoopprijs(int prijs) {

        this.aankoopprijs = prijs;

    }

    abstract protected int getMAX_ZITPLAATSEN();

    protected abstract Rijbewijs[] getToegestaneRijbewijzen();

    protected boolean checkRijbewijs(Mens bestuurder) {
        Collection<Rijbewijs> geldigeRijbewijzen = Arrays.asList(getToegestaneRijbewijzen());
        Collection<Rijbewijs> rijbewijzen = Arrays.asList(bestuurder.getRijbewijs());
        return CollectionUtils.containsAny(geldigeRijbewijzen, rijbewijzen);
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return this.merk;
    }

    public Datum getDatumEersteIngebruikname() {
        return this.datumEersteIngebruikname;
    }

    public int getAankoopprijs() {
        return this.aankoopprijs;
    }

    public Mens getBestuurder() {
        return bestuurder;
    }

    public int getZitplaatsen() {
        return this.zitplaatsen;
    }

    public void toonIngezettenen() {
        for (Mens inzit : ingezetenen) {
            System.out.println(inzit);
        }
    }

    public void addIngezetene(Mens nieuwIn) {
       
        if (ingezetenen.size() < this.zitplaatsen && !ingezetenen.contains(nieuwIn)) 
            ingezetenen.add(nieuwIn);
        else if (ingezetenen.size()==this.zitplaatsen&& !ingezetenen.contains(nieuwIn))
            throw new MensException();
       // else             throw new MensException();
    }

    public void removeIngezetene(Mens uit) {
        if (ingezetenen.size() > 0) {
            ingezetenen.remove(uit);
        }
    }
    
    public boolean isIngezetene(Mens a) {
        return ingezetenen.contains(a);

    }

    public Set<Mens> getIngezetenen() {

        return ingezetenen;

    }

    public Set<Mens> getIngezeteneExclusiefBestuurder() {
        Set<Mens> nieuw = new TreeSet();
        nieuw.addAll(ingezetenen);
        nieuw.remove(bestuurder);
        return nieuw;

    }
//    private class MerkComparator implements Comparator<Voertuig>,Serializable{
//        @Override
//        public int compare(Voertuig o1, Voertuig o2) {
//            return o1.aankoopprijs-o2.aankoopprijs;
//        }
//    }
//    //object met een bepaald gedrag maar van een onbekende klase
//    public Comparator<Voertuig> getMeComparator(){
//        return new MerkComparator();
//    }
//    //object met een bepaald gedrag maar van een onbekende klase, maar kan slechts één interface implementeren, dus is niet Serializeerbaar
//    public Comparator<Voertuig> getMeComparator(){
//        return new Comparator<Voertuig>(){
//           @Override
//        public int compare(Voertuig o1, Voertuig o2) {
//            return o1.aankoopprijs-o2.aankoopprijs;
//        } 
//        };
//    }

    private interface SerializableComparator<Voertuig> extends Comparator<Voertuig>, Serializable {
    };

    //Comparator-->SerializableComparator
    public static Comparator<Voertuig> getAankoopprijsComparator() {
        return new SerializableComparator<Voertuig>() {
            @Override
            public int compare(Voertuig o1, Voertuig o2) {
                return o1.aankoopprijs - o2.aankoopprijs;
            }
        };
    }

    public static Comparator<Voertuig> getMerkComparator() {
        return new SerializableComparator<Voertuig>() {
            @Override
            public int compare(Voertuig v1, Voertuig v2) {
                return v1.merk.compareTo(v2.merk);
            }
        };
    }

    @Override
    public int compareTo(Voertuig v) {
        return this.getNummerplaat().compareTo(v.getNummerplaat());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.merk);
        hash = 71 * hash + Objects.hashCode(this.datumEersteIngebruikname);
        hash = 71 * hash + this.aankoopprijs;
        hash = 71 * hash + this.zitplaatsen;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Voertuig) {

            Voertuig v = (Voertuig) obj;

            return this.getNummerplaat().equals(v.getNummerplaat());
        } else {
            return false;
        }
    }

    //nummerplaatString, merkString, datumString, aankoopprijsString, "Ammelie(B, B+E, C, C+E)" + " " + "[Anita, Bert]"
    @Override
    public String toString() {

        String nieuw = nummerplaat.toString() + " " + this.merk + " " + this.datumEersteIngebruikname.toString() + " " + this.aankoopprijs + " " + this.bestuurder;

        if (this.getIngezeteneExclusiefBestuurder().size() > 0) {
            return nieuw + " " + getIngezeteneExclusiefBestuurder().toString();
        } else {
            return nieuw;
        }

    }

}
