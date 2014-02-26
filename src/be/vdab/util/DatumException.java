package be.vdab.util;



/**
 *
 * @author vera.baikova
 */
public class DatumException extends Exception {
    
    public DatumException() {
    }
    
   public DatumException(String omschrijving) {
      super(omschrijving); }

   public DatumException(String omschrijving, Throwable ne) {
      super(omschrijving,ne);
       
   }
   public DatumException (Throwable ne){
     super(ne);
   }
   
}
