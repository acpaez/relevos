
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c-les
 */
public class Principal {
    public void principal(){
        Persona persona=new Persona();
        
        Hilo p11=new Hilo(persona);
        Hilo p12=new Hilo(persona);
        p11.start();
        p12.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized (persona){
            if (persona.pasosPersona()==33){
                persona.notifyAll();
            }
            if (persona.pasosPersona()==66){
                persona.notifyAll();
            }
        }   
        
    }
}
