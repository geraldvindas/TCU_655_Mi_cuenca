package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ucr.micuenca.BaseDeDatos.Comunidad;
import com.ucr.micuenca.BaseDeDatos.DatoGeneral;
import com.ucr.micuenca.BaseDeDatos.ASADA;

import java.util.ArrayList;
import java.util.List;

public class ASADAS extends Activity implements ListAdapter.ListAdapterOnClickHandler {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    private List<DatoGeneral> temp = new ArrayList<>();
    private List<ASADA> asadaList;
    private List<Comunidad> comunidadList;
    private Comunidad comunidad;
    private ASADA asada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("ASADAS");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(ASADAS.this, Menu.class);
                startActivity(next);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_item);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        mListAdapter = new ListAdapter(this);
        mRecyclerView.setAdapter(mListAdapter);

        asada = new ASADA();
        comunidad = new Comunidad();
        comunidadList = comunidad.getListaComunidad(getApplicationContext());
        asadaList = asada.getListaASADA(getApplicationContext());

        setDataList();
        mListAdapter.setListData(temp);

    }

    @Override
    public void onClick(String title) {

        boolean encontrado = false;
        int index = 0;
        while (index < asadaList.size() && !encontrado){
            if(asadaList.get(index).getTitulo().equals(title)){
                encontrado = true;
            }else{
                ++index;
            }
        }

        Intent actividadHijo = new Intent(ASADAS.this, VistaASADAS.class);
        actividadHijo.putExtra(Intent.EXTRA_TEXT, title);
        actividadHijo.putExtra("aguaConsumida", Integer.toString(asadaList.get(index).getAguaConsumida()));
        // actividadHijo.putExtra("constante", Integer.toString(asadaList.get(index).getConstante()));
        actividadHijo.putExtra("anoInfraestructura", Integer.toString(asadaList.get(index).getAnoInfraestructura()));
        actividadHijo.putExtra("anoCreacion", Integer.toString(asadaList.get(index).getAnoCreacion()));
        actividadHijo.putExtra("cantTomas", Integer.toString(asadaList.get(index).getCantidadTomas()));
        actividadHijo.putExtra("cantTuberias", Integer.toString(asadaList.get(index).getCantidadTuberias()));
        actividadHijo.putExtra("cantTanques", Integer.toString(asadaList.get(index).getCantidadTanques()));
        actividadHijo.putExtra("cantBeneficiados", Integer.toString(asadaList.get(index).getCantidadBeneficiados()));
        actividadHijo.putExtra("subcuenca", asadaList.get(index).getNombreSubcuenca());
        startActivity(actividadHijo);
    }

    public void setDataList(){
        temp.addAll(asadaList);
    }
}
