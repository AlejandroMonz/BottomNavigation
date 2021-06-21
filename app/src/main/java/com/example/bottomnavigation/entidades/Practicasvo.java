package com.example.bottomnavigation.entidades;

import java.io.Serializable;

public class Practicasvo implements Serializable { //se le implementa el serializable para transportar el objeto de un fragment a otro

    private String nombrePR;
    private String descripcion;
    private String info;
    private String code;
    private int imagenId;
    private int imagenDetalle;

    public Practicasvo(String nombrePR, String descripcion, String info, String code, int imagenId, int imagenDetalle) {
        this.nombrePR = nombrePR;
        this.descripcion = descripcion;
        this.info = info;
        this.code = code;
        this.imagenId = imagenId;
        this.imagenDetalle = imagenDetalle;
    }

    public String getNombrePR() {
        return nombrePR;
    }

    public void setNombrePR(String nombrePR) {
        this.nombrePR = nombrePR;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }
}
