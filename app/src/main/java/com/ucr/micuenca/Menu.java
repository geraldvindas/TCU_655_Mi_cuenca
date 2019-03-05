package com.ucr.micuenca;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Menu extends Activity {

    RelativeLayout mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FrameLayout mapa = findViewById(R.id.mapa);
        final FrameLayout conceptos = findViewById(R.id.conceptos);
        FrameLayout asadas  = findViewById(R.id.asadas);
        FrameLayout zonificacion = findViewById(R.id.zonificacion);
        FrameLayout datos = findViewById(R.id.datos);
        final FrameLayout leyes = findViewById(R.id.leyes);
        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Mapa.class);
                startActivity(next);
            }
        });

        //cambiar la clase dependiendo de la que quiera se llamada por el momento todas van a mapa

        conceptos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Mapa.class);
                startActivity(next);
            }
        });

        leyes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Laws.class);
                startActivity(next);
            }
        });

        asadas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Mapa.class);
                startActivity(next);
            }
        });
        datos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Mapa.class);
                startActivity(next);
            }
        });

        zonificacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Menu.this, Mapa.class);
                startActivity(next);
            }
        });

        checkFirstRun();
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso Legal");
            builder.setMessage("Esta aplicación es desarrollada por el Trabajo Comunal Universitario \n \t \"Gestión comunitaria del agua desde el manejo de cuencas hidrográficas\"\n7 mediante el uso de sistemas de información geográfica y software libre. Esta No debe ser utilizada con fines de lucro. Su contenido no tiene fuerza de ley, se dispone como insumo de carácter educativo y accionar social para las comunidades, entidades y personas interesadas.");
            builder.setCancelable(true);
            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Aceptado", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }
}
