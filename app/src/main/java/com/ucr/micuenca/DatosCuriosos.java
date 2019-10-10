package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ucr.micuenca.BaseDeDatos.DatoCurioso;

import java.util.List;
import java.util.Random;

public class DatosCuriosos extends Activity {

    Activity mParentActivity;
    static int anterior = 20;
    TextView mText;
    List<DatoCurioso> datos;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_curiosos);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Datos Curiosos");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(DatosCuriosos.this, Menu.class);
                startActivity(next);
            }
        });

        mText = findViewById(R.id.texto);
        mText.setMovementMethod(new ScrollingMovementMethod());

        DatoCurioso dato = new DatoCurioso();
        datos = dato.getDatosCuriosos(getApplicationContext());

        next();

        Button button  = findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                next();
            }
        });


    }

    //Metodo para escoger una dato curioso aleatorio diferente al anterior.

    public void next(){
        int random = anterior;
        Random rand = new Random();
        while(random == anterior) {
            random = rand.nextInt(datos.size());
        }
        anterior = random;
        if(random < datos.size())
            mText.setText(datos.get(random).getDato());
    }

}
