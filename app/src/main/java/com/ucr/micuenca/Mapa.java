package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class Mapa extends Activity {

    private MapView mMapView;


    private void setupMap() {
        if (mMapView != null) {
            Basemap.Type basemapType = Basemap.Type.STREETS_VECTOR;
            double latitude = 9.029868;
            double longitude = -83.050470;
            int levelOfDetail = 11;
            ArcGISMap map = new ArcGISMap(basemapType, latitude, longitude, levelOfDetail);
            showWebMap();
        }
    }

    public static Mapa newInstance() {
        return new Mapa();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        mMapView = findViewById(R.id.mapView);
        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Mapa");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Mapa.this, Menu.class);
                startActivity(next);
            }
        });

        showWebMap();
    }


    private void showWebMap() {
        String itemId = "453f5a7e73ba44c69090c150e3952dff";
        String url = "https://www.arcgis.com/sharing/rest/content/items/" + itemId + "/data";
        ArcGISMap map = new ArcGISMap(url);
        mMapView.setMap(map);
    }
}
