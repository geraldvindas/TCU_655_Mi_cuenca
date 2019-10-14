package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import com.ucr.micuenca.lib.zipfile.APKExpansionSupport;
import com.ucr.micuenca.lib.zipfile.ZipResourceFile;

import java.io.IOException;

public class PantallaCarga extends Activity {
    public static ZipResourceFile mExpansionFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);
        new CargarImagenes().execute();
        int loadtime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent next2 = new Intent(PantallaCarga.this, Menu.class);
                startActivity(next2);
                finish();
            }

        }, loadtime);
    }

    private class CargarImagenes extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(final Void... params) {
            try {
                mExpansionFile = APKExpansionSupport.getAPKExpansionZipFile(getApplicationContext(), 1, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
