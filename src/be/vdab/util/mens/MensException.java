/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.util.mens;


public class MensException extends RuntimeException{
    public MensException() {
    }
    
   public MensException(String omschrijving) {
      super(omschrijving); }

   public MensException(String omschrijving, Throwable ne) {
      super(omschrijving,ne);
       
   }
   public MensException (Throwable ne){
     super(ne);
   }
}
