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
public class InfoTareapp {
    String id_tareaabierta, fk_usuario, descripcion, direccion, nombre;

    public InfoTareapp(String id_tareaabierta, String fk_usuario, String descripcion, String direccion, String nombre) {
        this.id_tareaabierta = id_tareaabierta;
        this.fk_usuario = fk_usuario;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public String getId_tareaabierta() {
        return id_tareaabierta;
    }

    public void setId_tareaabierta(String id_tareaabierta) {
        this.id_tareaabierta = id_tareaabierta;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
