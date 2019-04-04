
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
public class Hilo extends Thread{
    private Persona persona;

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public Hilo(Persona persona) {
        super();
        this.persona = persona;
    }

    @Override
    public void run() {
        if(persona.avanzar()==33){
            synchronized (persona){
                try {
                    persona.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(persona.avanzar()==66){
            synchronized (persona){
                try {
                    persona.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
