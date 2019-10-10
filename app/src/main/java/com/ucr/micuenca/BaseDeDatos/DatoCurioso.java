package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatoCurioso implements Comparable<DatoCurioso> {
    int numero;
    String dato;
    String imagen;

    public DatoCurioso() {}
    public DatoCurioso(int numero, String dato, String imagen) {
        this.numero = numero;
        this.dato = dato;
        this.imagen = imagen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int compareTo(DatoCurioso o) {
        return 0;
    }

    public List<DatoCurioso> getDatosCuriosos(Context context){
        List<DatoCurioso> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Datos_Curiosos");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new DatoCurioso(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
