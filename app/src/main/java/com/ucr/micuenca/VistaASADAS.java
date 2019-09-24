package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ucr.micuenca.BaseDeDatos.Comunidad;

import java.util.ArrayList;
import java.util.List;

public class VistaASADAS extends Activity {

    private RecyclerView mRecyclerView;
    private List<Comunidad> comunidadList;
    private Comunidad comunidad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_asadas);

        Intent intentASADAS = getIntent();
        String textoRecibido = intentASADAS.getStringExtra(Intent.EXTRA_TEXT);

        comunidad = new Comunidad();
        comunidadList = comunidad.getListaComunidad(getApplicationContext());

        boolean encontrado = false;
        int index = 0;
        while (index < comunidadList.size() && !encontrado){
            if(comunidadList.get(index).getNombreASADA().equals(textoRecibido)){
                encontrado = true;
            }else{
                ++index;
            }
        }

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

        if(encontrado){
            String dato_nombreComunidad = comunidadList.get(index).getNombre();
            TextView nombreComunidad = findViewById(R.id.text_infoNombreComunidad);
            nombreComunidad.setText(dato_nombreComunidad);

            String dato_numeroHabitantes = String.valueOf(comunidadList.get(index).getCantidadHabitantes());
            TextView numeroHabitantes = findViewById(R.id.text_infoNumeroHabitantes);
            numeroHabitantes.setText(dato_numeroHabitantes);

            String dato_historia = comunidadList.get(index).getHistoria();
            TextView historia = findViewById(R.id.text_infoHistoria);
            historia.setText(dato_historia);
        }

    }





}
