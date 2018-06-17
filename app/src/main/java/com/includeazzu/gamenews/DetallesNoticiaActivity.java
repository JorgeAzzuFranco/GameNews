package com.includeazzu.gamenews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetallesNoticiaActivity extends AppCompatActivity {

    ImageView imagen;
    TextView titulo, fecha, cuerpo, juego;
    String strTitulo, strFecha, strCuerpo, strJuego, strImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_noticia);

        imagen = findViewById(R.id.imagenNoti);
        titulo = findViewById(R.id.tituloNoti);
        fecha = findViewById(R.id.fechaNoti);
        cuerpo = findViewById(R.id.cuerpoNoti);
        juego = findViewById(R.id.juegoNoti);


        strTitulo = getIntent().getStringExtra("titulo");
        strFecha = getIntent().getStringExtra("fecha");
        strCuerpo = getIntent().getStringExtra("cuerpo");
        strJuego = getIntent().getStringExtra("juego");
        strImagen = getIntent().getStringExtra("img");

        titulo.setText(strTitulo);
        fecha.setText(strFecha);
        cuerpo.setText(strCuerpo);
        juego.setText(strJuego);
        Picasso.with(this).load(strImagen).into(imagen);


    }
}
