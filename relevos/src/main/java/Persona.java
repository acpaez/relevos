
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
public class Persona extends Thread {

    Equipo equipo;
    private int pasos;
    private String nombre;
    private int posicionInicial;
    private int posicionFinal;
    Randoms random = new Randoms();
/**
 * Constructor para inicializar el deportista del equipo
 * @param equipo
 * @param nombre
 * @param posicionInicial
 * @param posicionFinal 
 */

    public Persona(Equipo equipo, String nombre, int posicionInicial, int posicionFinal) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.posicionInicial = posicionInicial;
        this.posicionFinal = posicionFinal;
    }
/**
 * metodo para saber cuantos pasos debe moverse el deportista
 * @return numero de pasos que debe dar el deportista
 */
    public int pasos() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        int numero1 = random.crearRamdom();
        if (numero1 == 1) {
            pasos += 1;
        } else if (numero1 == 2) {
            pasos += 2;
        } else {
            pasos += 3;
        }
        return pasos;
    }
/**
 * Metodo donde imprimimos la pista y vamos moviendo el primer deportista del equipo a travez de ella
 */
    public void avanzar() {
        while (true) {
            if (pasos >= 33) {
                synchronized (equipo) {
                    equipo.notify();
                    posicionInicial = 33;
                }
                break;
            }
            if (posicionInicial >= 0 && posicionFinal <= 33) {
                pasos = pasos();
            
                StringBuffer s = new StringBuffer("\nEquipo " + equipo.getEquipo()+"|................................2................................3..................................\n");
                System.out.print(s.insert(pasos+9, "1"));
            }
        }
    }
/**
 * Metodo donde imprimimos la pista y vamos moviendo el segundo deportista del equipo a travez de ella
 */
    public void avanzar2() {
        while (true) {
            if (pasos >= 66) {
                synchronized (equipo) {
                    equipo.notify();
                    posicionInicial = 66;
                }
                break;
            }
            if (posicionInicial > 33 && posicionFinal <= 66) {
                pasos = pasos();
                StringBuffer s = new StringBuffer("\nEquipo " + equipo.getEquipo()+"|................................1................................3..................................\n");
                System.out.print(s.insert(pasos+9, "2"));
            }

        }
    }
/**
 * Metodo donde imprimimos la pista y vamos moviendo el tercer deportista del equipo a travez de ella
 */
    public void avanzar3() {
        while (true) {
            
            if (pasos >= 100) {
                synchronized (equipo) {
                    System.out.println("\nEquipo " + equipo.getEquipo() + " Llegó a la meta primero");
                    System.exit(0);
                }
                break;
            }
            if (posicionInicial > 66 && posicionFinal<=100) {
                pasos = pasos();
                StringBuffer s = new StringBuffer("\nEquipo " + equipo.getEquipo()+"|................................1................................2..................................\n");
                System.out.print(s.insert(pasos+9, "3"));
            }
        }
    }
/**
 * metodo de inicio del hilo para cada deportista
 */
    @Override
    public void run() {
        if (posicionInicial == 0) {
            avanzar();
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (posicionInicial == 33) {
            avanzar2();
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (posicionInicial == 66) {
            avanzar3();
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
/**
 * guardar en la variable privada equipo
 * @param equipo 
 */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
/**
 * guardar en la variable privada pasos que da el deportista
 * @param pasos 
 */
    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
/**
 * guardar en la variable privada nombre para el deportista 
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * guardar en la variable posicion inicial para el deportista
 * @param posicionInicial 
 */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
/**
 * guardar en la variable posicion final para saber donde termina el deportista
 * @param posicionFinal 
 */
    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }
/**
 * guardar el numero randomico para saber cuantos pasos debe dar el deportista
 * @param random 
 */
    public void setRandom(Randoms random) {
        this.random = random;
    }
/**
 * 
 * @return el equipo al que pertenece el deportista
 */
    public Equipo getEquipo() {
        return equipo;
    }
/**
 * 
 * @return los pasos que ha dado el deportista 
 */
    public int getPasos() {
        return pasos;
    }
/**
 * 
 * @return el nombre del deportista
 */
    public String getNombre() {
        return nombre;
    }
/**
 * 
 * @return la posicion inical del deportista
 */
    public int getPosicionInicial() {
        return posicionInicial;
    }
/**
 * 
 * @return la posicion final del deportista
 */
    public int getPosicionFinal() {
        return posicionFinal;
    }
/**
 * 
 * @return el numero randomico generado
 */
    public Randoms getRandom() {
        return random;
    }

}
