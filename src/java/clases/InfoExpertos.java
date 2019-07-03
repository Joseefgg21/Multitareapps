/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Jose Fernando G2
 */
public class InfoExpertos {

    String id_serviciousuario, fk_usuario, fk_servicio, descripcion, experiencia, cobro, foto, ciudad, nombre;

    public InfoExpertos(String id_serviciousuario, String fk_usuario, String fk_servicio, String descripcion, String experiencia, String cobro, String foto, String ciudad, String nombre) throws IOException {
        this.id_serviciousuario = id_serviciousuario;
        this.fk_usuario = fk_usuario;
        this.fk_servicio = fk_servicio;
        this.descripcion = descripcion;
        this.experiencia = experiencia;
        this.cobro = cobro;
        this.foto = DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get(foto)));
        this.ciudad = ciudad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getId_serviciousuario() {
        return id_serviciousuario;
    }

    public void setId_serviciousuario(String id_serviciousuario) {
        this.id_serviciousuario = id_serviciousuario;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getFk_servicio() {
        return fk_servicio;
    }

    public void setFk_servicio(String fk_servicio) {
        this.fk_servicio = fk_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String cobro) {
        this.cobro = cobro;
    }

}
