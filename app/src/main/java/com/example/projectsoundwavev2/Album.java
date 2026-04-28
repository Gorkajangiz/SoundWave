package com.example.projectsoundwavev2;

public class Album {
    private String nombre;
    private String artista;
    private int imagenResId;

    public Album(String nombre, String artista, int imagenResId) {
        this.nombre = nombre;
        this.artista = artista;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }
    public String getArtista() {
        return artista;
    }
    public int getImagenResId() {
        return imagenResId;
    }
}