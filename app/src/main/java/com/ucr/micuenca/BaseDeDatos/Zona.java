package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zona extends DatoGeneral implements Comparable<Zona>{
    String nombre;
    String descripcion;
    String actividad;
//    String imagen;

    public Zona(String nombre, String descripcion, String actividad/*, String imagen*/) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;

//        if(imagen != null){
//            this.imagen = imagen;
//        }else{
//            this.imagen = "zonifEjem.jpg";
//        }
    }

    public Zona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    //La idea es poder llamar a la imgen desde la BD a partir del nombre
//    public String getImagen(){ return imagen; }
//
//    public void setImagen(String imagen){ this.imagen = imagen; }

    @Override
    public String getTitulo() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int compareTo(Zona o) {
        return 0;
    }

    public List<Zona> getListaZona(Context context){
        List<Zona> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Zona");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new Zona(cursor.getString(0), cursor.getString(1), cursor.getString(2)/*, cursor.getString(3)*/));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
