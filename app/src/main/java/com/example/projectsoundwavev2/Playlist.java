package com.example.projectsoundwavev2;

public class Playlist {
    private String nombre;
    private int imagenResId;

    public Playlist(String nombre, int imagenResId) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }
    public int getImagenResId() {
        return imagenResId;
    }
}