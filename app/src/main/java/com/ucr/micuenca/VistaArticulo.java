package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaArticulo extends Activity {

    private TextView mTituloArticulo;
    private TextView mDescripcionArticulo;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);

        titulo = findViewById(R.id.tv_titulo);
        mTituloArticulo = (TextView) findViewById(R.id.tv_titulo_articulo);
        mDescripcionArticulo = (TextView) findViewById(R.id.tv_descripcion_articulo);

        Intent intentArticulo = getIntent();

        if (intentArticulo.hasExtra(Intent.EXTRA_TEXT)) {
            this.titulo.setText("Articulo");

            String tituloArticulo = intentArticulo.getStringExtra(Intent.EXTRA_TEXT);
            String tituloLey = intentArticulo.getStringExtra("idLey");
            this.mTituloArticulo.setText(tituloLey + ": " + tituloArticulo);

            String dato_descripcion = intentArticulo.getStringExtra("descripcion");
            this.mDescripcionArticulo.setText(dato_descripcion);

            RelativeLayout menu = findViewById(R.id.titulo_menu);
            menu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent next = new Intent(VistaArticulo.this, Menu.class);
                    startActivity(next);
                }
            });
        }
    }

}