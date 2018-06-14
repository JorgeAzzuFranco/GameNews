package com.includeazzu.gamenews.Fragmentos;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.includeazzu.gamenews.APIGameNews.ApiUtiles;
import com.includeazzu.gamenews.APIGameNews.GameNewsAPI;
import com.includeazzu.gamenews.Adapter.NoticiasAdapter;
import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NoticiasRecientesFragment extends Fragment {

    View noticiasRecientes;
    RecyclerView recycler;
    LinearLayoutManager glm;
    SharedPreferences prefs;
    GameNewsAPI gameNewsAPI;
    String token;
    Noticia[] noti;
    NoticiasAdapter adapter;

    public NoticiasRecientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        noticiasRecientes = inflater.inflate(R.layout.fragment_noticias_recientes, container, false);

        prefs = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
        token = prefs.getString("tokenpdm", "noToken");
        Log.d("TOKEN", "token: "+token);

        recycler = noticiasRecientes.findViewById(R.id.mi_recycler);
        recycler.setHasFixedSize(true);
        glm = new LinearLayoutManager(getContext().getApplicationContext());
        recycler.setLayoutManager(glm);

        gameNewsAPI = ApiUtiles.getGameNewsAPI();
        cargarNoticias(token);

        return noticiasRecientes;
    }

    private void cargarNoticias(String token) {
        gameNewsAPI.getNoticias(token).enqueue(new Callback<Noticia[]>() {
            @Override
            public void onResponse(Call<Noticia[]> call, Response<Noticia[]> response) {
                if (response.isSuccessful()) {
                    noti = response.body();
                    Log.d("ALGOINFO", "titulo: "+noti[0].getTituloNoticia());
                    adapter = new NoticiasAdapter(noti);
                    recycler.setAdapter(adapter);

                } else {
                    int statusCode = response.code();
                    Log.d("ERROR", "Codigo de red: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<Noticia[]> call, Throwable t) {
                Log.d("Error", t.toString() + "");
            }
        });
    }

    public interface OnNavigationItemSelectedListener {
    }

}
