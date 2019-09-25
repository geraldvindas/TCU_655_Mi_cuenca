package com.ucr.micuenca;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Recursos extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursos);

        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Recursos");
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(Recursos.this, Menu.class);
                startActivity(next);
            }
        });
    }

    public void goToFacebook (View view) {
        goToUrl ( "https://www.facebook.com/TCU655/");
    }

    public void goToYoutube (View view) {
        goToUrl ( "https://www.ucr.ac.cr/noticias/2016/09/12/ucr-presento-diagnostico-de-la-sub-cuenca-del-rio-coto.html");
    }

    public void goToDescarga (View view) {
        goToUrl ( "https://mega.nz/#F!BxR31S4B!ilbE-0BVa8QMk1tgk2cNHA");
    }

    public void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
