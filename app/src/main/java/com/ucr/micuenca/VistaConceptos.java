package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaConceptos extends Activity{
    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_conceptos);

        Intent intentConceptos = getIntent();
        String textoRecibido = intentConceptos.getStringExtra(Intent.EXTRA_TEXT);


        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText(textoRecibido);
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaConceptos.this, Menu.class);
                startActivity(next);
            }
        });

        String dato_resumenConcepto = intentConceptos.getStringExtra("resumenConcepto");
        TextView resumenConcepto= findViewById(R.id.text_infoResumenConcepto);
        resumenConcepto.setText(dato_resumenConcepto);

    }
}
