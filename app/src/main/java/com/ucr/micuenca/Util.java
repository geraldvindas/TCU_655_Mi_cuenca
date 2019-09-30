package com.ucr.micuenca;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.io.InputStream;

public class Util {

    public static final int TAMANO_DESCRIPCION_LISTA = 120;
    public static final String URL_IMAGEN_DEFECTO = "imagenes/zonif_ejm.jpg";
    public static final String URL_IMAGENES_CONCEPTO = "imagenes/conceptos/";

    public static int getColor(int position, Context context){
        int module = position % 6;
        module = 8;
        switch (module){
            case 0:
                return ContextCompat.getColor(context, R.color.color1);
            case 1:
                return ContextCompat.getColor(context, R.color.color2);
            case 2:
                return ContextCompat.getColor(context, R.color.color3);
            case 3:
                return ContextCompat.getColor(context, R.color.color4);
            case 4:
                return ContextCompat.getColor(context, R.color.color5);
                case 5:
                return ContextCompat.getColor(context, R.color.colorSecundary);
            default:
                return ContextCompat.getColor(context, R.color.black);

        }
    }

    public static String recortarTexto(String texto, int caracteres){
        if (texto.length() >= caracteres)
            return texto.substring(0,caracteres) + "...";
        return texto;
    }

    public static Drawable loadDrawableFromAssets(Context context, String path)
    {
        try {
            InputStream stream = context.getAssets().open(URL_IMAGENES_CONCEPTO + path);
            return Drawable.createFromStream(stream, null);
        } catch (Exception ignored) {
            InputStream stream = null;
            try {
                stream = context.getAssets().open(URL_IMAGEN_DEFECTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Drawable.createFromStream(stream, null);
        }
    }
}
