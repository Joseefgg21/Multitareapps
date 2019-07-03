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
public class ExpertoRecomendado {
    String id_serviciousuario, fk_usuario, fk_servicio, descripcion, experiencia, 
       cobro, fecha_creacion, fecha_modificacion, estado, foto;

    public ExpertoRecomendado(String id_serviciousuario, String fk_usuario, String fk_servicio, String descripcion, String experiencia, String cobro, String fecha_creacion, String fecha_modificacion, String estado, String foto) throws IOException {
        this.id_serviciousuario = id_serviciousuario;
        this.fk_usuario = fk_usuario;
        this.fk_servicio = fk_servicio;
        this.descripcion = descripcion;
        this.experiencia = experiencia;
        this.cobro = cobro;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.estado = estado;
        this.foto =DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get(foto)));
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


}
