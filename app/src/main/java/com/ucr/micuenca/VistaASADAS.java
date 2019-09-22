package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VistaASADAS extends Activity {

    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_asadas);

        Intent intentASADAS = getIntent();
        String textoRecibido = intentASADAS.getStringExtra(Intent.EXTRA_TEXT);


        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("ASADAS");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaASADAS.this, Menu.class);
                startActivity(next);
            }
        });

        TextView nombre_Asada = findViewById(R.id.tv_titulo_asada);
        nombre_Asada.setText(textoRecibido);

        String dato_aguaConsumida = intentASADAS.getStringExtra("aguaConsumida");
        TextView aguaConsumida = findViewById(R.id.text_infoAguaConsumida);
        aguaConsumida.setText(dato_aguaConsumida + " l/hab/día");

//        String dato_constante = intentASADAS.getStringExtra("constante");
//        TextView constante = findViewById(R.id.text_infoConstante);
//        constante.setText(dato_constante);

        String dato_anoInfraestructura = intentASADAS.getStringExtra("anoInfraestructura");
        TextView anoInfraestructura = findViewById(R.id.text_infoAnoInfraestructura);
        anoInfraestructura.setText(dato_anoInfraestructura);

        String dato_anoCreacion = intentASADAS.getStringExtra("anoCreacion");
        TextView anoCreacion = findViewById(R.id.text_infoAnoCreacion);
        anoCreacion.setText(dato_anoCreacion);

        String dato_cantTomas = intentASADAS.getStringExtra("cantTomas");
        TextView cantTomas = findViewById(R.id.text_infoCantidadTomas);
        cantTomas.setText(dato_cantTomas);

        String dato_cantTuberias = intentASADAS.getStringExtra("cantTuberias");
        TextView cantTuberias = findViewById(R.id.text_infoCantidadTuberias);
        cantTuberias.setText(dato_cantTuberias);

        String dato_cantTanques = intentASADAS.getStringExtra("cantTanques");
        TextView cantTanques = findViewById(R.id.text_infoCantidadTanques);
        cantTanques.setText(dato_cantTanques);

        String dato_cantPersonasBeneficiadas = intentASADAS.getStringExtra("cantBeneficiados");
        TextView cantBeneficiados = findViewById(R.id.text_infoCantidadBeneficiados);
        cantBeneficiados.setText(dato_cantPersonasBeneficiadas);

        String dato_subCuenca = intentASADAS.getStringExtra("subcuenca");
        TextView subcuenca = findViewById(R.id.text_infoNombreSubcuenca);
        subcuenca.setText(dato_subCuenca);

        String dato_imagenASADA = intentASADAS.getStringExtra("imagen");
        ImageView imagen = findViewById(R.id.imageView_imgASADA);
        imagen.setImageDrawable(Util.loadDrawableFromAssets(getApplicationContext(), dato_imagenASADA));

    }





}
