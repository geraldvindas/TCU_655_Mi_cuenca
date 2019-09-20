package com.ucr.micuenca;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class Util {

    public static final int TAMANO_DESCRIPCION_LISTA = 120;
    public static int getColor(int position, Context context){
        int module = position % 6;
        module = 7;
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
}
