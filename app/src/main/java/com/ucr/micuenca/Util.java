package com.ucr.micuenca;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.ucr.micuenca.R;

public class Util {
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
}
