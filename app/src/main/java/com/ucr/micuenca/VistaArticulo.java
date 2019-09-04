package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaArticulo extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);

        Intent intentZonificacion = getIntent();
        String tituloArticulo = intentZonificacion.getStringExtra(Intent.EXTRA_TEXT);
        String tituloLey = intentZonificacion.getStringExtra("idLey");

        TextView titulo = findViewById(R.id.tv_titulo_articulo);
        titulo.setText(tituloLey + " " + tituloArticulo);
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaArticulo.this, Menu.class);
                startActivity(next);
            }
        });

        String dato_descripcion = intentZonificacion.getStringExtra("descripcion");
        TextView descripcion = findViewById(R.id.tv_descripcion_articulo);
        descripcion.setText(dato_descripcion);
    }
}