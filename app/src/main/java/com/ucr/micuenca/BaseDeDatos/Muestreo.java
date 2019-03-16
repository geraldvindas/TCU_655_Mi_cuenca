package com.ucr.micuenca.BaseDeDatos;

import java.util.Date;

public class Muestreo implements Comparable<Muestreo> {
    String nombreASADA;
    int numero;
    String descripcion;
    String resultado;
    String calidad;
    Date fecha;


    public Muestreo(String nombreASADA, int numero, String descripcion, String resultado, String calidad, Date fecha) {
        this.nombreASADA = nombreASADA;
        this.numero = numero;
        this.descripcion = descripcion;
        this.resultado = resultado;
        this.calidad = calidad;
        this.fecha = fecha;
    }

    public String getNombreASADA() {
        return nombreASADA;
    }

    public void setNombreASADA(String nombreASADA) {
        this.nombreASADA = nombreASADA;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int compareTo(Muestreo o) {
        return 0;
    }
}
