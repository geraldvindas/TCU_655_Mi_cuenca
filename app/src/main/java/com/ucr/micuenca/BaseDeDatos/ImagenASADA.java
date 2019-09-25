package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagenASADA implements Comparable<ImagenASADA> {
    String nombreASADA;
    String imagen;

    public ImagenASADA(String nombreASADA, String imagen) {
        this.nombreASADA = nombreASADA;
        this.imagen = imagen;
    }

    public ImagenASADA() {}

    public String getNombreASADA() {
        return nombreASADA;
    }

    public void setNombreASADA(String nombreASADA) {
        this.nombreASADA = nombreASADA;
    }

    public String getImagen() {
        return "imagenes/" + imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int compareTo(ImagenASADA o) {
        return 0;
    }

    public List<ImagenASADA> getListaImagenAsada(Context context){
        List<ImagenASADA> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("Imagen_ASADA");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new ImagenASADA(cursor.getString(0), cursor.getString(1)
            ));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
