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
public class CategoriaServicio {
    String id_categoriaservicio;
    String nombre;

    public CategoriaServicio(String id_categoriaservicio, String nombre) {
        this.id_categoriaservicio = id_categoriaservicio;
        this.nombre = nombre;
    }

    public String getId_categoriaservicio() {
        return id_categoriaservicio;
    }

    public void setId_categoriaservicio(String id_categoriaservicio) {
        this.id_categoriaservicio = id_categoriaservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
            
}
