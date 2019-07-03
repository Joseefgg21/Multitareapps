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
public class Usuario {

    String id_usuario, fk_rol, fk_ciudad, correo, contrasena, nombres, apellidos, experto, foto, direccion, fecha_nacimiento, telefono, fecha_creacion, fecha_modificacion, estado, creacion;

    public Usuario(String id_usuario, String fk_rol, String fk_ciudad, String correo, String contrasena, String nombres, String apellidos, String experto, String foto, String direccion, String fecha_nacimiento, String telefono, String fecha_creacion, String fecha_modificacion, String estado, String creacion) {
        this.id_usuario = id_usuario;
        this.fk_rol = fk_rol;
        this.fk_ciudad = fk_ciudad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.experto = experto;
        this.foto = foto;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.estado = estado;
        this.creacion = creacion;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFk_rol() {
        return fk_rol;
    }

    public void setFk_rol(String fk_rol) {
        this.fk_rol = fk_rol;
    }

    public String getFk_ciudad() {
        return fk_ciudad;
    }

    public void setFk_ciudad(String fk_ciudad) {
        this.fk_ciudad = fk_ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getExperto() {
        return experto;
    }

    public void setExperto(String experto) {
        this.experto = experto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }
    
    
     
}
