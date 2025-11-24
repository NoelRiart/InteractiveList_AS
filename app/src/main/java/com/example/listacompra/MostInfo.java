package com.example.listacompra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostInfo extends AppCompatActivity {

    private ImageView imgProducto;
    private TextView tvNombre, tvTipo, tvCantidad, tvCategoria, tvInfoCategoria;
    private Button btnAbrirWeb, btnCompWhats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrarinfo);

        imgProducto = findViewById(R.id.imgProductoDetalle);
        tvNombre = findViewById(R.id.tvNombreDetalle);
        tvTipo = findViewById(R.id.tvTipoDetalle);
        tvCantidad = findViewById(R.id.tvCantidadDetalle);
        tvCategoria = findViewById(R.id.tvCategoriaDetalle);
        tvInfoCategoria = findViewById(R.id.tvInfoCategoria);
        btnAbrirWeb = findViewById(R.id.btnAbrirWeb);
        btnCompWhats = findViewById(R.id.btnCompWhats);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvNombre.setText(extras.getString("nombre", ""));
            tvTipo.setText(extras.getString("tipo", ""));
            tvCantidad.setText(extras.getString("cantidad", ""));
            tvCategoria.setText(extras.getString("categoria", ""));
            tvInfoCategoria.setText(extras.getString("InfoCategoria", ""));
            String url = extras.getString("url", "");
            imgProducto.setImageResource(extras.getInt("imagen", 0));


            tvInfoCategoria.setVisibility(View.VISIBLE);

            //Intent explicito abrir web
            btnAbrirWeb.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            });

            //Intent generico compartir
            btnCompWhats.setOnClickListener(v -> {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "\n" + url);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "Compartir con...");
                startActivity(shareIntent);
            });

        }
    }


}
