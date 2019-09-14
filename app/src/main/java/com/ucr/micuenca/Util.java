package com.ucr.micuenca;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class Util {

    public static final int TAMANO_DESCRIPCION_LISTA = 180;
    public static int getColor(int position, Context context){
        int module = position % 6;
        switch (module){
            case 0:
                return ContextCompat.getColor(context, R.color.magentaOscuro);
            case 1:
                return ContextCompat.getColor(context, R.color.orange);
            case 2:
                return ContextCompat.getColor(context, R.color.red_orange);
            case 3:
                return ContextCompat.getColor(context, R.color.black_blue);
            case 4:
                return ContextCompat.getColor(context, R.color.magenta);
            default:
                return ContextCompat.getColor(context, R.color.black);

        }
    }

    public static String recortarTexto(String texto, int caracteres){
        if (texto.length() >= caracteres)
            return texto.substring(0,caracteres);
        return texto;
    }
}
