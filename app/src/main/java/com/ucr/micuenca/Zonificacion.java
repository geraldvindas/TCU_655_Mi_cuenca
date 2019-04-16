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

import com.ucr.micuenca.BaseDeDatos.DatoGeneral;
import com.ucr.micuenca.BaseDeDatos.Zona;

import java.util.ArrayList;
import java.util.List;

public class Zonificacion extends Activity implements ListAdapter.ListAdapterOnClickHandler {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    private List<DatoGeneral> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Zonificación");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Zonificacion.this, Menu.class);
                startActivity(next);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_item);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        mListAdapter = new ListAdapter(this);
        mRecyclerView.setAdapter(mListAdapter);
        setDataList();
        mListAdapter.setListData(temp);



    }

    @Override
    public void onClick(String title) {
        Context context = this;
        Toast.makeText(context, title, Toast.LENGTH_SHORT)
                .show();
    }

    public void setDataList(){
        Zona zona = new Zona();
        List<Zona> zonaList = zona.getListaZona(getApplicationContext());
        temp.addAll(zonaList);
    }
}
