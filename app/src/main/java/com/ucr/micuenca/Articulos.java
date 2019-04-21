package com.ucr.micuenca;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ucr.micuenca.BaseDeDatos.Articulo;
import com.ucr.micuenca.BaseDeDatos.DatoGeneral;
import com.ucr.micuenca.Leyes;
import com.ucr.micuenca.ListAdapter;
import com.ucr.micuenca.Menu;
import com.ucr.micuenca.R;

import java.util.ArrayList;
import java.util.List;

public class Articulos extends AppCompatActivity implements ListAdapter.ListAdapterOnClickHandler {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    private String idLey;

    private List<DatoGeneral> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);



        Intent intentLeyes = getIntent();
        if( intentLeyes.hasExtra(Intent.EXTRA_TEXT)){
            String textoRecibido = intentLeyes.getStringExtra(Intent.EXTRA_TEXT);

            TextView titulo = findViewById(R.id.tv_titulo);
            titulo.setText("Articulos "+textoRecibido);
            //this.idLey = textoRecibido;
            RelativeLayout menu = findViewById(R.id.titulo_menu);
            menu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent next = new Intent(Articulos.this, Menu.class);
                    startActivity(next);
                }
            });

            mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_item);

            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(linearLayoutManager);

            mRecyclerView.setHasFixedSize(true);

            mListAdapter = new ListAdapter(this);
            mRecyclerView.setAdapter(mListAdapter);
            setDataList(textoRecibido);
            mListAdapter.setListData(temp);
        }

    }

    @Override
    public void onClick(String title) {
        Intent actividadHijo = new Intent(this, Articulos.class);
        actividadHijo.putExtra(Intent.EXTRA_TEXT, title);
        ArrayList<String> datos = new ArrayList<>();
        datos.add(title);
        datos.add(this.idLey);
        actividadHijo.putStringArrayListExtra("Datos",datos);
        startActivity(actividadHijo);
    }

    public void setDataList(String nombreLey){
        Articulo articulo = new Articulo();
        List<Articulo> leyList = articulo.getListaArticuloLey(getApplicationContext(), nombreLey);
        temp.addAll(leyList);
    }
}
