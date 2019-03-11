package com.ucr.micuenca.BaseDeDatos;

public class DatosCuriosos implements Comparable<DatosCuriosos> {
    int numero;
    String dato;
    String imagen;

    public DatosCuriosos(int numero, String dato, String imagen) {
        this.numero = numero;
        this.dato = dato;
        this.imagen = imagen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int compareTo(DatosCuriosos o) {
        return 0;
    }
}
