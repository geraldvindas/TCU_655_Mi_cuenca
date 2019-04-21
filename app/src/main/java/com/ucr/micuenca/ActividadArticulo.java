package com.ucr.micuenca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ucr.micuenca.BaseDeDatos.Articulo;

import java.util.ArrayList;

public class ActividadArticulo extends AppCompatActivity {
    private TextView mTituloArticulo;
    private TextView mDescripcionArticulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);

        mTituloArticulo = (TextView) findViewById(R.id.tv_titulo_articulo);
        mDescripcionArticulo = (TextView) findViewById(R.id.tv_descripcion_articulo);
        Intent intentActividadHijo = getIntent();

        if (intentActividadHijo.hasExtra("Datos")) {
            ArrayList<String> datosRecibidos = intentActividadHijo.getStringArrayListExtra("Datos");
            mTituloArticulo.setText(String.format("%s %s", datosRecibidos.get(0), datosRecibidos.get(1)));

            String descripcion = getDescripcion(datosRecibidos.get(0), Integer.parseInt(datosRecibidos.get(1)));
            mDescripcionArticulo.setText(descripcion);
        }
    }

    private String getDescripcion(String nombreLey, int numeroArticulo){
        Articulo articulo = new Articulo();
        return  articulo.getArticulo(this,nombreLey,numeroArticulo).getDescripcion();
    }
}