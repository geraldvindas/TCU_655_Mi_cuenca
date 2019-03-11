package com.ucr.micuenca.BaseDeDatos;

public class Zona implements Comparable<Zona> {
    String nombre;
    String descripcion;
    String actividad;

    public Zona(String nombre, String descripcion, String actividad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;
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

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public int compareTo(Zona o) {
        return 0;
    }
}
