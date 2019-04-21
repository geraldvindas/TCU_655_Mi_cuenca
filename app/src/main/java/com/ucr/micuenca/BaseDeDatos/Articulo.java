package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Articulo extends DatoGeneral implements Comparable<Articulo>{
    String nombreLey;
    int numero;
    String descripcion;

    public Articulo(){}

    public Articulo(String nombreLey, int numero, String descripcion){
        this.nombreLey = nombreLey;
        this.descripcion = descripcion;
        this.numero = numero;
    }

    public String getNombreLey() {
        return nombreLey;
    }

    public void setNombreLey(String nombreLey) {
        this.nombreLey = nombreLey;
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

    @Override
    public int compareTo(Articulo o) {
        return 0;
    }

    @Override
    public String getTitulo() {
        return this.descripcion;
    }

    public List<Articulo> getListaArticuloLey(Context context, String nombreLey){
        List<Articulo> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerListaPorId("Articulo", "Nombre_Ley", nombreLey);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new Articulo(cursor.getString(0), cursor.getInt(1),cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }

    public Articulo getArticulo(Context context, String nombreLey, int numArticulo){
        Articulo articulo;
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerEntidad("SELECT * FROM Articulo WHERE Nombre_Ley = \""+nombreLey+"\" AND Numero = " + numArticulo);
        cursor.moveToFirst();
        articulo = new Articulo(cursor.getString(0), cursor.getInt(1),cursor.getString(2));
        cursor.moveToNext();
        cursor.close();
        accesoDatos.close();
        return articulo;
    }

}
