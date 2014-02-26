package be.vdab.be.main;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.util.mens.Mens;
import static be.vdab.util.mens.Rijbewijs.*;
import be.vdab.voertuigen.*;
import java.awt.Color;
import java.io.*;
import java.util.Set;

import java.util.TreeSet;

public class Programma {

    private final Mens BESTUURDER_B = new Mens("Bernard", B);
    private final Mens BESTUURDER_BC = new Mens("Beatrice", B, C);
    private final Mens BESTUURDER_C = new Mens("Catherina", C);
    private final Mens BESTUURDER_BBECCE = new Mens("Ammelie", B, BE, C, CE);

    private final Mens INGEZETENE_A = new Mens("Anita");
    private final Mens INGEZETENE_B = new Mens("Bert");
    private final Mens INGEZETENE_C = new Mens("Christina");
    private final Mens INGEZETENE_D = new Mens("Duts");
    private final Mens INGEZETENE_E = new Mens("Elsa");
    private final Mens INGEZETENE_F = new Mens("Fred");

    private final Datum Datum_1 = new Datum(01, 01, 2001);
    private final Datum Datum_2 = new Datum(02, 02, 2002);
    private final Datum Datum_3 = new Datum(03, 03, 2003);
    private final Datum Datum_4 = new Datum(04, 04, 2004);
    private final Datum Datum_5 = new Datum(05, 05, 2005);
    private final Datum Datum_6 = new Datum(06, 06, 2006);

    private final Color KLEUR_1 = Color.PINK;
    private final Color KLEUR_2 = Color.RED;
    private final Color KLEUR_3 = Color.BLUE;
    private final Color KLEUR_4 = Color.BLACK;

    //(int hoogte, int breedte, int diepte, Maat maat)
    private final Volume VOLUME1 = new Volume(10, 10, 10, Maat.decimeter);
    private final Volume VOLUME2 = new Volume(12, 12, 12, Maat.decimeter);

    private static Personenwagen pers1, pers2;
    private static Pickup pickup1, pickup2;
    private static Vrachtwagen vr1, vr2;

    public Programma() throws DatumException, VolumeException {

        pers1 = new Personenwagen("Audi", Datum_1, 1000, 4, KLEUR_1, BESTUURDER_B, INGEZETENE_A);
        pers2 = new Personenwagen("BMW", Datum_2, 5000, 4, KLEUR_2, BESTUURDER_BC, INGEZETENE_B);
        //String merk, Datum d, int prijs, int zitplaatsen, Color kleur,Volume vol, Mens bestuurder, Mens... persoon)
        pickup1 = new Pickup("Volkswagen", Datum_3, 1240, 3, KLEUR_3, VOLUME1, BESTUURDER_C, INGEZETENE_C);
        pickup2 = new Pickup("BMW", Datum_4, 5900, 3, KLEUR_4, VOLUME2, BESTUURDER_BBECCE, INGEZETENE_D);

        vr1 = new Vrachtwagen("Mercedes", Datum_5, 12000, 2, VOLUME1, 10, 3, BESTUURDER_C, INGEZETENE_E);
        vr2 = new Vrachtwagen("Toyota", Datum_6, 14562, 2, VOLUME2, 15, 4, BESTUURDER_BC, INGEZETENE_F);
    }

    public static void main(String[] args) throws DatumException, VolumeException {
        // TODO code application logic here

        Programma prog = new Programma();
        Set<Voertuig> Vervoer = new TreeSet<Voertuig>(Voertuig.getAankoopprijsComparator());
        Set<Voertuig> Vervoer2 = new TreeSet<Voertuig>(Voertuig.getMerkComparator());
        Set<Voertuig> Vervoer3;
        
        
        vul(Vervoer);
        System.out.println();
        System.out.println("--------Op aankoopprijs gesorteerd--------");
        soort(Vervoer);

        vul(Vervoer2);
        System.out.println();
        System.out.println("--------Op merk gesorteerd--------");
        soort(Vervoer2);

        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            fileOut = new FileOutputStream("wagenpark.ser");
            objOut = new ObjectOutputStream(fileOut);

        //array wegschrijven (array elementen worden automatisch ook 
            //weggeschreven)
            objOut.writeObject(Vervoer2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (objOut != null) {
                try {
                    //outputstream sluiten 
                    objOut.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
            //een nieuwe fileInputstream en objectInputstream maken 
            fileIn = new FileInputStream("wagenpark.ser");
            objIn = new ObjectInputStream(fileIn);
            Vervoer3 = (TreeSet<Voertuig>) objIn.readObject();
            System.out.println();
            System.out.println("------Gegevens uit de file(gesorteerd op basis van merk)------");
            System.out.println();
            for (Voertuig vrt : Vervoer3) {
                
                System.out.println(vrt.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            //de file sluiten 
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    private static void vul(Set nieuwSet) {
        nieuwSet.add(pers1);
        nieuwSet.add(pers2);
        nieuwSet.add(pickup1);
        nieuwSet.add(pickup2);
        nieuwSet.add(vr1);
        nieuwSet.add(vr2);
    }

    private static void soort(Set nieuwSet) {

        for (Object obj : nieuwSet) {
            Voertuig v = (Voertuig) obj;
            // v.getAankoopPrijsComparator();
            System.out.println(v);
        }

    }

}
