package com.includeazzu.gamenews.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.adapter.rxjava.Result;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasViewHolder> {

    Noticia[] noticias;

    public NoticiasAdapter(Noticia[] noticias) {
        this.noticias = noticias;
    }

    @Override
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_noticias, parent, false);
        return new NoticiasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticiasAdapter.NoticiasViewHolder holder, int position) {
        holder.tituloNoticia.setText(noticias[position].getTituloNoticia());
        holder.descNoticia.setText(noticias[position].getDescNoticia());
        //holder.img.getResources(noticias.get(position).getImagenNoticia());

    }

    @Override
    public int getItemCount() {
        return noticias.length;
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
