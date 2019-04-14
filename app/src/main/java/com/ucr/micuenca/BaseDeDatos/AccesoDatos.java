package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccesoDatos {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDatos;
    private static AccesoDatos instancia;


    public static AccesoDatos getInstance(Context context) {
        if (instancia == null) {
            instancia = new AccesoDatos(context);
        }
        return instancia;
    }


    public AccesoDatos(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    public void open() {
        this.baseDatos = openHelper.getWritableDatabase();
    }

    public void close() {
        if (baseDatos != null) {
            this.baseDatos.close();
        }
    }

    public Cursor obtenerLista(String nombreTabla){
        List<Ley> lista = new ArrayList<>();
        Cursor cursor = baseDatos.rawQuery("SELECT * FROM "+nombreTabla+";", null);
        return cursor;
    }


}
