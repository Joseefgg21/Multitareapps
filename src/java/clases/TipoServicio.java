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
public class TipoServicio {
    
    String id_tiposervicio;
    String nombre;

    public TipoServicio(String tiposervicio, String nombre) {
        this.id_tiposervicio = tiposervicio;
        this.nombre = nombre;
    }

    public String getId_tiposervicio() {
        return id_tiposervicio;
    }

    public void setId_tiposervicio(String id_tiposervicio) {
        this.id_tiposervicio = id_tiposervicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
