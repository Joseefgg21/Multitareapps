/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jose Fernando G2
 */
public class Ciudad {
    int id_ciudad;
    String nombre;

    public Ciudad(int id_ciuad, String Nombre) {
        this.id_ciudad = id_ciuad;
        this.nombre = Nombre;
    }

    public int getId_ciuad() {
        return id_ciudad;
    }

    public void setId_ciuad(int id_ciuad) {
        this.id_ciudad = id_ciuad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
    
}
