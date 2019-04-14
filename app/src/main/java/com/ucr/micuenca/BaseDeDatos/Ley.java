package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ley extends DatoGeneral implements Comparable<Ley>{
    String nombre;
    String resumen;
    AccesoDatos accesoDatos;

    public Ley(String nombre, String resumen) {
        this.nombre = nombre;
        this.resumen = resumen;
    }

    public Ley(){}

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

    public List<Ley> getListaLey(Context context){
        List<Ley> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Ley");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new Ley(cursor.getString(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
