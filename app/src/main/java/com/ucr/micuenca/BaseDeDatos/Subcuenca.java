package com.ucr.micuenca.BaseDeDatos;

public class Subcuenca implements Comparable<Subcuenca> {
    String nombre;
    String rioPrincipal;

    public Subcuenca(String nombre, String rioPrincipal) {
        this.nombre = nombre;
        this.rioPrincipal = rioPrincipal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRioPrincipal() {
        return rioPrincipal;
    }

    public void setRioPrincipal(String rioPrincipal) {
        this.rioPrincipal = rioPrincipal;
    }

    @Override
    public int compareTo(Subcuenca o) {
        return 0;
    }
}
