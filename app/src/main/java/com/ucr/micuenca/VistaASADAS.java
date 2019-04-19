package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaASADAS extends Activity {

    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_asadas);
        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("ASADA " /*+ "nombreASADA" */);
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaASADAS.this, Menu.class);
                startActivity(next);
            }
        });


        // necesita jalar la info del item de la lista que se clickeo para mostrar el activity y ya

    }





}
