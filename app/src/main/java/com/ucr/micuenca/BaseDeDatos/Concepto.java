package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concepto extends DatoGeneral implements Comparable<Concepto> {
    String nombreConcepto;
    String resumenConcepto;
    String fotoConcepto;

    public Concepto(String nombre, String resumen, String foto) {
        this.nombreConcepto = nombre;
        this.resumenConcepto = resumen;
        this.fotoConcepto = foto;
    }

    public Concepto(){}

    public Concepto(String nombre, String resumen){
        this.nombreConcepto = nombre;
        this.resumenConcepto = resumen;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombre) {
        this.nombreConcepto = nombre;
    }

    public String getResumenConcepto() {
        return resumenConcepto;
    }

    public void setResumenConcepto(String resumen) {
        this.resumenConcepto = resumen;
    }

    public String getFotoConcepto() {
        return fotoConcepto;
    }

    public void setFotoConcepto(String foto) {
        this.fotoConcepto = foto;
    }

    @Override
    public String getTitulo() {
        return nombreConcepto;
    }

    @Override
    public String getDescripcion() {
        return resumenConcepto;
    }

    @Override
    public int compareTo(Concepto o) {
        return 0;
    }

    public List<Concepto> getListaConcepto(Context context){
        List<Concepto> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Concepto");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new Concepto(cursor.getString(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
