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

public class Articulos extends Activity implements ListAdapter.ListAdapterOnClickHandler {
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
            this.idLey = intentLeyes.getStringExtra(Intent.EXTRA_TEXT);

            TextView titulo = findViewById(R.id.tv_titulo);
            titulo.setText(this.idLey);
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
            setDataList(this.idLey);
            mListAdapter.setListData(temp);
        }

    }

    @Override
    public void onClick(String title) {
        boolean encontrado = false;
        int index = 0;
        while (index < this.temp.size() && !encontrado){
            if(temp.get(index).getTitulo().equals(title)){
                encontrado = true;
            }else{
                ++index;
            }
        }
        if(encontrado) {
            Intent actividadHijo = new Intent(Articulos.this, VistaArticulo.class);
            actividadHijo.putExtra(Intent.EXTRA_TEXT, title);
            actividadHijo.putExtra("idLey", this.idLey);
            actividadHijo.putExtra("descripcion", temp.get(index).getDescripcion());
            startActivity(actividadHijo);
        }

    }

    public void setDataList(String nombreLey){
        Articulo articulo = new Articulo();
        this.temp.clear();
        List<Articulo> leyList = articulo.getListaArticuloLey(getApplicationContext(), nombreLey);
        temp.addAll(leyList);
    }
}
