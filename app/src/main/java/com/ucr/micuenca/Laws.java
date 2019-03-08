package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Laws extends Activity {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    private List<String> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);

        TextView titulo = findViewById(R.id.titulo);
        titulo.setText("Leyes");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Laws.this, Menu.class);
                startActivity(next);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_item);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        mListAdapter = new ListAdapter(temp);
        mRecyclerView.setAdapter(mListAdapter);

        loadData();


     }

     public void loadData(){
        temp.add("Ley 1");
        temp.add("Ley 2");
        temp.add("Ley 3");
        temp.add("Ley 4");
        temp.add("Ley 5");
        temp.add("Ley 6");
        temp.add("Ley 7");
        temp.add("Ley 8");
        temp.add("Ley 9");
        temp.add("Ley 10");

        mListAdapter.notifyDataSetChanged();

     }
}
