package com.ucr.micuenca;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import androidx.recyclerview.widget.RecyclerView;
        import android.view.View;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.ImageView;

public class VistaZonificacion extends Activity {

    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_zonificacion);

        Intent intentZonificacion = getIntent();
        String textoRecibido = intentZonificacion.getStringExtra(Intent.EXTRA_TEXT);


        TextView titulo = findViewById(R.id.tv_titulo);
        titulo.setText("Zonificación");

        TextView tituloZonificacion = findViewById(R.id.tv_titulo_zonificacion);
        tituloZonificacion.setText(textoRecibido);
        RelativeLayout menu = findViewById(R.id.titulo_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(VistaZonificacion.this, Menu.class);
                startActivity(next);
            }
        });

        String dato_descripcion = intentZonificacion.getStringExtra("descripcion");
        TextView descripcion = findViewById(R.id.text_infoDescripcion);
        descripcion.setText(dato_descripcion);

        String dato_actividad = intentZonificacion.getStringExtra("actividad");
        TextView actividad = findViewById(R.id.text_infoActividad);
        actividad.setText(dato_actividad);

        String dato_imagenZona = intentZonificacion.getStringExtra("imagen");
        ImageView imagen = findViewById(R.id.imageView_imgZona);
        imagen.setImageDrawable(Util.loadDrawableFromAssets(getApplicationContext(), dato_imagenZona));

    }
}























