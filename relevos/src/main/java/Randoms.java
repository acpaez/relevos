
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c-les
 */
public class Randoms {
    /**
     * el metodo genera un numero randomico de 0 a 3
     * @return el numero randomico
     */
   public static int crearRamdom(){
       Random aleatorio = new Random(System.currentTimeMillis());
       int numero=aleatorio.nextInt(3);
       return numero;
   }
}
