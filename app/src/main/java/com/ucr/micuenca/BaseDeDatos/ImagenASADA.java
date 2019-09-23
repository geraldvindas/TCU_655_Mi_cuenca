package com.ucr.micuenca.BaseDeDatos;

public class ImagenASADA implements Comparable<ImagenASADA> {
    String nombreASADA;
    String imagen;

    public ImagenASADA(String nombreASADA, String imagen) {
        this.nombreASADA = nombreASADA;
        this.imagen = imagen;
    }

    public String getNombreASADA() {
        return nombreASADA;
    }

    public void setNombreASADA(String nombreASADA) {
        this.nombreASADA = nombreASADA;
    }

    public String getImagen() {
        return "imagenes/" + imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int compareTo(ImagenASADA o) {
        return 0;
    }
}
