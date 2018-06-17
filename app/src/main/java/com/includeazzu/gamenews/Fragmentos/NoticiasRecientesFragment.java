package com.includeazzu.gamenews.Fragmentos;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.includeazzu.gamenews.APIGameNews.ApiUtiles;
import com.includeazzu.gamenews.APIGameNews.GameNewsAPI;
import com.includeazzu.gamenews.Adapter.NoticiasAdapter;
import com.includeazzu.gamenews.DBRoom.NoticiasDatabase;
import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NoticiasRecientesFragment extends Fragment {

    View noticiasRecientes;
    RecyclerView recycler;
    GridLayoutManager glm;
    SharedPreferences prefs;
    GameNewsAPI gameNewsAPI;
    String token;
    List<Noticia> noti;
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
        glm = new GridLayoutManager(getContext().getApplicationContext(), 2);

        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                if(position % 3 == 0) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
        });

        recycler.setLayoutManager(glm);

        NoticiasDatabase.getInstance(getContext());
        gameNewsAPI = ApiUtiles.getGameNewsAPI();
        cargarNoticias(token);

        return noticiasRecientes;
    }

    private void cargarNoticias(String token) {
        gameNewsAPI.getNoticias(token).enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if (response.isSuccessful()) {
                    if (NoticiasDatabase.myDB.getAll().size() == 0){
                    noti = response.body();
                    NoticiasDatabase.myDB.addNoticia(noti);
                    adapter = new NoticiasAdapter(NoticiasDatabase.myDB.getAll());
                    recycler.setAdapter(adapter);
                    }
                    else{
                        adapter = new NoticiasAdapter(NoticiasDatabase.myDB.getAll());
                        recycler.setAdapter(adapter);
                    }

                } else {
                    int statusCode = response.code();
                    Log.d("ERROR", "Codigo de red: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Log.d("Error", t.toString() + "");
            }
        });
    }

    public interface OnNavigationItemSelectedListener {
    }

}
