package com.includeazzu.gamenews.DBRoom;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.includeazzu.gamenews.POJO.Noticia;

import java.util.List;

//@Dao
public interface NoticiasDAO {

    //Para obtener todas las noticias y mostrarlas
    //en la pantalla de inicio
    //@Query("SELECT * FROM NOTICIA")
    List<Noticia> getAll();

    //Obtiene todas las noticias de los juegos
   //@Query("SELECT * FROM NOTICIA WHERE JUEGO LIKE :juego")
    List<Noticia> getNoticias(String juego);

}
