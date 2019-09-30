package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ucr.micuenca.BaseDeDatos.DatoGeneral;
import com.ucr.micuenca.BaseDeDatos.Ley;

import java.util.ArrayList;
import java.util.List;

public class Leyes extends Activity implements ListAdapter.ListAdapterOnClickHandler {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    private List<DatoGeneral> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Leyes");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Leyes.this, Menu.class);
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
            Intent actividadHijo = new Intent(Leyes.this, Articulos.class);
            actividadHijo.putExtra(Intent.EXTRA_TEXT, title);

            actividadHijo.putExtra("resumenLey", this.temp.get(index).getDescripcion());

            startActivity(actividadHijo);
        }


    }

    public void setDataList(){
       Ley ley = new Ley();
       List<Ley> leyList = ley.getListaLey(getApplicationContext());
       temp.addAll(leyList);
     }
}
