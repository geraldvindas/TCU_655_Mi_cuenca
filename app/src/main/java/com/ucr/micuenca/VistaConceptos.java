package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ucr.micuenca.Menu;
import com.ucr.micuenca.R;
import com.ucr.micuenca.Util;

public class VistaConceptos extends Activity{
    public static final String URL_IMAGENES_CONCEPTO = "imagenes/conceptos/";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_conceptos);

        Intent intentConceptos = getIntent();
        String tituloConcepto = intentConceptos.getStringExtra(Intent.EXTRA_TEXT); //Aquí se obtiene nombre de concepto a mostrar

        String dato_resumenConcepto = intentConceptos.getStringExtra("resumenConcepto");
        String dato_descripcionConcepto = intentConceptos.getStringExtra("descripcionConcepto");
        String dato_imagenConcepto = intentConceptos.getStringExtra("imagenConcepto");


        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Definición concepto");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(v -> {
            Intent next = new Intent(VistaConceptos.this, Menu.class);
            startActivity(next);
        });

        TextView nombreConcepto = findViewById(R.id.tv_titulo_concepto);
        nombreConcepto.setText(tituloConcepto);

        ImageView imageView = findViewById(R.id.imageView_imgConcepto);
        if(dato_imagenConcepto != null)
            dato_imagenConcepto = URL_IMAGENES_CONCEPTO + dato_imagenConcepto;
        imageView.setImageDrawable(Util.loadDrawableFromAssets(getApplicationContext(), dato_imagenConcepto));


//
//        imageView.getLayoutParams().height = ViewGroup.LayoutParams.;
//        imageView.getLayoutParams().width = 1;

        System.out.println("tamanio " + imageView.getLayoutParams().height + " " + imageView.getLayoutParams().width);


        TextView resumenConcepto= findViewById(R.id.text_infoResumenConcepto);
        resumenConcepto.setText(dato_resumenConcepto);



    }
}
