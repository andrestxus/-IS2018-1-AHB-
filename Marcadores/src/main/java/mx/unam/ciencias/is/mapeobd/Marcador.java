/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapeobd;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que modela un marcador apartir de la tabla marcador
 * @author jonathan
 */
@Entity
@Table(name="marcador")
public class Marcador {
    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "idmarcador")
        private int marcador_id;
    @Column(name = "nombreM")
        private String  nombre_M;
    @Column(name = "latitud")
        private double lat;
    @Column(name = "longitud")
        private double longi;

    public String getNombre_M() {
        return nombre_M;
        
        /**Nos da el nombre
     * @return el nombre de usuario 
    */
    }

    public void setNombre_M(String nombre_M) {
        this.nombre_M = nombre_M;
    }

    public double getLat() {
        return lat;
        /**Nos da la latitud
     * @return devuelve latitud 
    */
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
        /**Nos da la longitud
     * @return longitud
    */
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public String getDescription() {
        return description;
        /**Nos da la descripcinó
     * @return la descripción 
    */
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "descripcion")
        private String description;
    //Aqui va tu codigo
    
    /**Nos da el id del marcador
     * @return el id del marcador 
    */
    public int getMarcador_id() {
        return marcador_id;
    }
    
    /** Pone el id del marcador.
      @param marcador_id 
    */
    public void setMarcador_id(int marcador_id) {
        this.marcador_id = marcador_id;
    }
    
    
    //Aqui va tu codigo
}
