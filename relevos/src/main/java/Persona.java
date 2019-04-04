
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
public class Persona{
    int pasos;

    public int avanzar(){
        Randoms random=new Randoms();
        while(pasos<=100){
            int numero1=random.crearRamdom();
            if (numero1==1){
                pasos+=1;
            }else if(numero1==2){
                pasos+=2;
            }else{
                pasos+=3;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (pasos<=33){
                StringBuffer s = new StringBuffer(".................................2...............................3.....................................");
                System.out.println(s.insert(pasos, "1"));
                if(pasos==33){
                    return pasos;
                }
            }else if(pasos >33 && pasos <=66){
                StringBuffer s = new StringBuffer(".................................1...............................3.....................................");
                System.out.println(s.insert(pasos, "2"));
                if(pasos==66){
                    return pasos;
                }
            }else{
                StringBuffer s = new StringBuffer(".................................1...............................2.....................................");
                System.out.println(s.insert(pasos, "3"));
            }
        }
        return pasos;
    }
    public int pasosPersona(){
        return pasos;
    }
}
