package com.ucr.micuenca;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ucr.micuenca.BaseDeDatos.AccesoDatos;
import com.ucr.micuenca.BaseDeDatos.DatoGeneral;
import com.ucr.micuenca.BaseDeDatos.Concepto;

import java.util.ArrayList;
import java.util.List;

public class Conceptos extends Activity implements ListAdapter.ListAdapterOnClickHandler{
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    private List<DatoGeneral> temp = new ArrayList<>();
    private List<Concepto> conceptoList;
    private Concepto concepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Conceptos");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Conceptos.this, Menu.class);
                startActivity(next);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_item);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        mListAdapter = new ListAdapter(this);
        mRecyclerView.setAdapter(mListAdapter);

        concepto = new Concepto();
        conceptoList = concepto.getListaConcepto(getApplicationContext());

        setDataList();
        mListAdapter.setListData(temp);



    }

    @Override
    public void onClick(String title) {

        boolean encontrado = false;
        int index = 0;
        while (index < conceptoList.size() && !encontrado){
            if(conceptoList.get(index).getTitulo().equals(title)){
                encontrado = true;
            }else{
                ++index;
            }
        }

        Intent actividadHijo = new Intent(Conceptos.this, VistaConceptos.class);
        actividadHijo.putExtra(Intent.EXTRA_TEXT, title);
        actividadHijo.putExtra("resumenConcepto", conceptoList.get(index).getResumenConcepto());
        startActivity(actividadHijo);
    }

    public void setDataList(){
        temp.addAll(conceptoList);
    }

}
