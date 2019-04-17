package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concepto extends DatoGeneral implements Comparable<Concepto> {
    String nombre;
    String resumen;
    String foto;

    public Concepto(String nombre, String resumen, String foto) {
        this.nombre = nombre;
        this.resumen = resumen;
        this.foto = foto;
    }

    public Concepto(){}

    public Concepto(String nombre, String resumen){
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
