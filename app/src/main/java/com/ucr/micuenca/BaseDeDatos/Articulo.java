package com.ucr.micuenca.BaseDeDatos;

public class Articulo implements Comparable<Articulo>{
    String nombreLey;
    int numero;
    String descripcion;

    public String getNombreLey() {
        return nombreLey;
    }

    public void setNombreLey(String nombreLey) {
        this.nombreLey = nombreLey;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int compareTo(Articulo o) {
        return 0;
    }
}
