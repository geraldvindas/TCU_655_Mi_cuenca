package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PantallaCarga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        int loadtime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next = new Intent(PantallaCarga.this, Menu.class);
                startActivity(next);
                finish();
            }

        }, loadtime);
    }
}
