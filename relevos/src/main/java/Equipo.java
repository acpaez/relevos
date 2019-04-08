/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c-les
 */
public class Equipo {
    /**
     * variable para guardar el nombre del equipo que en este caso
     * es un numero
     */
    private int equipo;
/**
 * constructor donde recibimos el numero del equipo
 * @param equipo 
 */
    public Equipo(int equipo) {
        this.equipo = equipo;
    }
/**
 * guardamos el nombre del equipo
 * @param equipo 
 */
    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
/**
 * 
 * @return el nombre del equipo 
 */
    public int getEquipo() {
        return equipo;
    }
}
