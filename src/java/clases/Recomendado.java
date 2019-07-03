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
public class Recomendado {

    String id_empresarecomendado, fk_empresa, nombre, descripcion, foto;

    public Recomendado(String id_empresarecomendado, String fk_empresa, String nombre, String descripcion, String foto) throws IOException {
        this.id_empresarecomendado = id_empresarecomendado;
        this.fk_empresa = fk_empresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get(foto)));
    }

    public String getId_empresarecomendado() {
        return id_empresarecomendado;
    }

    public void setId_empresarecomendado(String id_empresarecomendado) {
        this.id_empresarecomendado = id_empresarecomendado;
    }

    public String getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(String fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    
}
