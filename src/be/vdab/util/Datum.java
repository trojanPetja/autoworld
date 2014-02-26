/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 * 1.State of immutable object can not be modified after construction, any
 * modification should result in new immutable object. 2. All fields of
 * Immutable class should be final. 3. Object must be properly constructed i.e.
 * object reference must not leak during construction process. 4. Object should
 * be final in order to restrict sub-class for altering immutability of parent
 * class.
 */
public final class Datum implements Serializable, Comparable<Datum> {

    private final int dag, maand, jaar;

    //throws DatumException ??
    public Datum(int d, int m, int j) throws DatumException {

        if (maandIsCorrect(m) == false || jaarIsCorrect(j) == false || dagIsCorrect(d) == false) {
            throw new DatumException("Verkeerde datum");
        } else {
            maand = m;
            jaar = j;
            if (eenEnDertigDagen(d, m) == true) {
                dag = d;
            } else if (dertigDagen(d, m) == true) {
                dag = d;
            } else if (d <= 29 && isSchrikkeljaar(j) == true) {
                dag = d;
            } else if (d <= 28 && isSchrikkeljaar(j) == false) {
                dag = d;
            } else {
                throw new DatumException("Verkeerde dag");
            }
        }
    }

    private boolean jaarIsCorrect(int j) {
        if (j > 1582 && j < 4100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean maandIsCorrect(int m) {
        return m > 0 && m < 13;

    }

    private boolean isSchrikkeljaar(int j) {
        return (j % 4 == 0 && j%100 !=0 || j%400==0); 

    }

    private boolean dertigDagen(int d, int m) {

        if ((m == 4 || m == 6 || m == 9 || m == 11) && (d > 0 && d < 31)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean eenEnDertigDagen(int d, int m) {

        if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && (d > 0 && d < 32)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return (String.format("%02d", dag) + "/" + String.format("%02d", maand) + "/" + jaar);
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {

        return jaar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Datum) {
            Datum d = (Datum) obj;
            return (dag == d.dag && maand == d.maand && jaar == d.jaar);
        } else {
            return false;
        }
    }

    

    @Override
    public int hashCode() {
        
        return toInt();
    }

    private boolean dagIsCorrect(int d) {
        if (d > 0 && d <= 31) {
            return true;
        } else {
            return false;
        }
    }

    private int toInt(){
        return jaar*10000+maand*100+dag;
    }
    
    @Override
    public int compareTo(Datum dat) {
        return this.toInt()-dat.toInt();
    }
}
