
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author vera.baikova
 */
public enum Maat implements Serializable{
    centimeter(1),decimeter(10),meter(100);
    
    private final int verhouding;
    private Maat(int verhouding){
        this.verhouding=verhouding;
    }
    public long get3DVerhouding(){
        return ((long)verhouding)*verhouding*verhouding;
    }
}   
    
 
