package com.example.bottomnavigation;

public class PersonajesVo {

    private String nombre;      //Son privates porque debe generar el metodo get, set y el constructor
    private String info;
    private int foto;

    public PersonajesVo(){

    }


    public PersonajesVo(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInfo() {
        return info;
    }

    public int getFoto() {
        return foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
