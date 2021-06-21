package com.example.bottomnavigation.entidades;

public class Devicesvo {

    private String nombreDevice;
    private int ImagenDevice;

    public Devicesvo(String nombreDevice, int imagenDevice) {
        this.nombreDevice = nombreDevice;
        ImagenDevice = imagenDevice;
    }

    public String getNombreDevice() {
        return nombreDevice;
    }

    public void setNombreDevice(String nombreDevice) {
        this.nombreDevice = nombreDevice;
    }

    public int getImagenDevice() {
        return ImagenDevice;
    }

    public void setImagenDevice(int imagenDevice) {
        ImagenDevice = imagenDevice;
    }
}
