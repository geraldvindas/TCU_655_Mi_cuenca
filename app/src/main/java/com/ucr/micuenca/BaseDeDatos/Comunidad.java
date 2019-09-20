package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comunidad  implements Comparable<Comunidad> {
    String nombre;
    String distrito;
    String canton;
    int tamano;
    int cantidadHabitantes;
    String historia;
    String nombreASADA;


    public Comunidad(String nombre, String distrito, String canton, int tamano, int cantidadHabitantes, String historia, String nombreASADA) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.canton = canton;
        this.tamano = tamano;
        this.cantidadHabitantes = cantidadHabitantes;
        this.historia = historia;
        this.nombreASADA = nombreASADA;
    }

    public Comunidad(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public void setCantidadHabitantes(int cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNombreASADA() {
        return nombreASADA;
    }

    public void setNombreASADA(String nombreASADA) {
        this.nombreASADA = nombreASADA;
    }

    @Override
    public int compareTo(Comunidad o) {
        return 0;
    }

    public List<Comunidad> getListaComunidad(Context context){
        List<Comunidad> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Comunidad");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new Comunidad(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getInt(3), cursor.getInt(4), cursor.getString(5)
                    , cursor.getString(6)
                    ));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
