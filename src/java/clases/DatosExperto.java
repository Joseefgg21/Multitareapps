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
public class DatosExperto {

    String id_documentoexperto, fk_usuario, fotocopia_cedula, foto, factura,
            fecha_incio, fecha_fin, fecha_creacion, fecha_modificacion, estado,
            rut;

    public DatosExperto(String id_documentoexperto, String fk_usuario, String fotocopia_cedula, String foto, String factura, String fecha_incio, String fecha_fin, String fecha_creacion, String fecha_modificacion, String estado, String rut) {
        this.id_documentoexperto = id_documentoexperto;
        this.fk_usuario = fk_usuario;
        this.fotocopia_cedula = fotocopia_cedula;
        this.foto = foto;
        this.factura = factura;
        this.fecha_incio = fecha_incio;
        this.fecha_fin = fecha_fin;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.estado = estado;
        this.rut = rut;
    }

    public String getId_documentoexperto() {
        return id_documentoexperto;
    }

    public void setId_documentoexperto(String id_documentoexperto) {
        this.id_documentoexperto = id_documentoexperto;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getFotocopia_cedula() {
        return fotocopia_cedula;
    }

    public void setFotocopia_cedula(String fotocopia_cedula) {
        this.fotocopia_cedula = fotocopia_cedula;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFecha_incio() {
        return fecha_incio;
    }

    public void setFecha_incio(String fecha_incio) {
        this.fecha_incio = fecha_incio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

}
