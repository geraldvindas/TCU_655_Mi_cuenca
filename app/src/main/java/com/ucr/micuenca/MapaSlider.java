package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

public class MapaSlider extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_imagenes);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Imagenes Mapa");
        RelativeLayout menu = findViewById(R.id.titulo_menu);

        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(MapaSlider.this, Menu.class);
                startActivity(next);
            }
        });

        ViewPager viewPager = findViewById(R.id.activity_mapa_slider);
        MapaImagenes mapa_imagenes = new MapaImagenes(this);
        viewPager.setAdapter(mapa_imagenes);

    }
}
