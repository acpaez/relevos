
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
/**
 * creamos los equipos con sus respectivos deportistas 
 */
    Equipo equipo = new Equipo(1);
    Equipo equipo2 = new Equipo(2);
    Equipo equipo3 = new Equipo(3);

    Persona persona = new Persona(equipo, "Atleta 1", 0, 33);
    Persona persona1 = new Persona(equipo, "Atleta 2", 33, 66);
    Persona persona2 = new Persona(equipo, "Atleta 3", 66, 100);
    Persona persona3 = new Persona(equipo2, "Atleta 4", 0, 33);
    Persona persona4 = new Persona(equipo2, "Atleta 5", 33, 66);
    Persona persona5 = new Persona(equipo2, "Atleta 6", 66, 100);
    Persona persona6 = new Persona(equipo3, "Atleta 7", 0, 33);
    Persona persona7 = new Persona(equipo3, "Atleta 8", 33, 66);
    Persona persona8 = new Persona(equipo3, "Atleta 9", 66, 100);

    /**
     * inicializamos los hilos de los 9 deportistas 
     */
    public void principal() {
        persona.start();
        persona1.start();
        persona2.start();
        
        persona3.start();
        persona4.start();
        persona5.start();
        
        persona6.start();
        persona7.start();
        persona8.start();
    }
}
