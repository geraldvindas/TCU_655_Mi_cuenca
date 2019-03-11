package com.ucr.micuenca.BaseDeDatos;

public class ComunidadZona implements Comparable<ComunidadZona> {
    String nombreComunidad;
    String distrito;
    String canton;
    String nombreZona;

    public ComunidadZona(String nombreComunidad, String distrito, String canton, String nombreZona) {
        this.nombreComunidad = nombreComunidad;
        this.distrito = distrito;
        this.canton = canton;
        this.nombreZona = nombreZona;
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    @Override
    public int compareTo(ComunidadZona o) {
        return 0;
    }
}
