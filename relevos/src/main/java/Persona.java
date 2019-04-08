
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

    public Persona(Equipo equipo, String nombre, int posicionInicial, int posicionFinal) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.posicionInicial = posicionInicial;
        this.posicionFinal = posicionFinal;
    }

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

    public void avanzar() {
        while (true) {
            pasos = pasos();
            if (pasos >= 33) {
                synchronized (equipo) {
                    equipo.notify();
                    posicionInicial = 33;
                }
                break;
            }
            System.out.print("Equipo " + equipo.getEquipo());
            StringBuffer s = new StringBuffer("................................2................................3..................................");
            System.out.println(s.insert(pasos, "1"));
        }
    }

    public void avanzar2() {
        while (true) {
            pasos = pasos();
            if (pasos >= 66) {
                synchronized (equipo) {
                    equipo.notify();
                    posicionInicial = 66;
                }
                break;
            }
            System.out.print("Equipo " + equipo.getEquipo());
            StringBuffer s = new StringBuffer("................................1................................3..................................");
            System.out.println(s.insert(pasos, "2"));

        }
    }

    public void avanzar3() {
        while (true) {
            pasos = pasos();
            if (pasos >= 100) {
                synchronized (equipo) {
                    System.out.println("Equipo " + equipo.getEquipo() + " Llegó a la meta primero");
                    System.exit(0);
                }
                break;
            }
            System.out.print("Equipo " + equipo.getEquipo());
            StringBuffer s = new StringBuffer("................................1................................2..................................");
            System.out.println(s.insert(pasos, "3"));
        }
    }

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

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    public void setRandom(Randoms random) {
        this.random = random;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getPasos() {
        return pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicionInicial() {
        return posicionInicial;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public Randoms getRandom() {
        return random;
    }

}
