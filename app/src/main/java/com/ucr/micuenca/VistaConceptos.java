package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaConceptos extends Activity{
    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_conceptos);

        Intent intentConceptos = getIntent();
        String textoRecibido = intentConceptos.getStringExtra(Intent.EXTRA_TEXT); //Aquí se obtiene nombre de concepto a mostrar


        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Definición concepto");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaConceptos.this, Menu.class);
                startActivity(next);
            }
        });

        TextView nombreConcepto = findViewById(R.id.tv_titulo_concepto);
        nombreConcepto.setText(textoRecibido);

        String dato_resumenConcepto = intentConceptos.getStringExtra("resumenConcepto");
        TextView resumenConcepto= findViewById(R.id.text_infoResumenConcepto);
        resumenConcepto.setText(dato_resumenConcepto);

    }
}
