package com.includeazzu.gamenews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.includeazzu.gamenews.DetallesNoticiaActivity;
import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.adapter.rxjava.Result;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasViewHolder> {

    List<Noticia> noticias;

    public NoticiasAdapter(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    @Override
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_noticias, parent, false);
        return new NoticiasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticiasAdapter.NoticiasViewHolder holder, final int position) {
        holder.tituloNoticia.setText(noticias.get(position).getTituloNoticia());
        holder.descNoticia.setText(noticias.get(position).getDescNoticia());
        //holder.img.getResources(noticias.get(position).getImagenNoticia());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detalleNoticia = new Intent(v.getContext(), DetallesNoticiaActivity.class);

                String titulo = noticias.get(position).getTituloNoticia();
                String fecha = noticias.get(position).getFechaNoticia();
                String cuerpo = noticias.get(position).getCuerpoNoticia();
                String juego = noticias.get(position).getJuego();

                detalleNoticia.putExtra("titulo", titulo);
                detalleNoticia.putExtra("fecha", fecha);
                detalleNoticia.putExtra("cuerpo", cuerpo);
                detalleNoticia.putExtra("juego", juego);

                v.getContext().startActivity(detalleNoticia);
            }
        });

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }


    public class NoticiasViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        int idNoticia;
        TextView tituloNoticia;
        TextView descNoticia;
        ImageView img;
        ImageButton fav;


        public NoticiasViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cv_noticias);
            tituloNoticia = itemView.findViewById(R.id.txtnoticia);
            descNoticia = itemView.findViewById(R.id.txtDescripcion);
            img = itemView.findViewById(R.id.imagen);
            fav = itemView.findViewById(R.id.btnfav);
        }
    }
}
