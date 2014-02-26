
package be.vdab.util.mens;

/**
 *
 * @author vera.baikova
 */
public enum Rijbewijs {
    
    A,B,BE,C,CE,D,DE;

    @Override
    public String toString(){
        String tekst=super.toString();
        if(tekst.length()==2){
            tekst = tekst.charAt(0)+"+"+tekst.charAt(1);
        }
        return tekst;
    }
  }

