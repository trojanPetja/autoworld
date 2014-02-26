package be.vdab.util;

/**
 *
 * @author vera.baikova
 */
public class VolumeException extends Exception{
    
    public VolumeException() {
    }
    
   public VolumeException(String omschrijving) {
      super(omschrijving); }

   public VolumeException(String omschrijving, Throwable ne) {
      super(omschrijving,ne);
       
   }
   public VolumeException (Throwable ne){
     super(ne);
   }
    
}
