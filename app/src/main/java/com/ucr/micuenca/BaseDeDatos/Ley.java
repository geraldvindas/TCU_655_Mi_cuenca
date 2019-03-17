package com.ucr.micuenca.BaseDeDatos;

public class Ley extends DatoGeneral implements Comparable<Ley>{
    String nombre;
    String resumen;

    public Ley(String nombre, String resumen) {
        this.nombre = nombre;
        this.resumen = resumen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String getTitulo() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return resumen;
    }

    @Override
    public int compareTo(Ley o) {
        return 0;
    }
}
