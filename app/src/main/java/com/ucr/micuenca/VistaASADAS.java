package com.ucr.micuenca;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class VistaASADAS extends Activity {

    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("ASADA " /*+ "nombreASADA" */);

        // necesita jalar la info del item de la lista que se clickeo para mostrar el activity y ya

    }





}
