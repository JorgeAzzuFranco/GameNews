package com.includeazzu.gamenews.DBRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.POJO.Player;

import java.util.List;

//@Dao
public interface PlayerDAO {

    //Para obtener todas las noticias y mostrarlas
    //en la pantalla de inicio
    //@Query("SELECT * FROM PLAYER")
    List<Player> getAll();

    //Obtiene todas las noticias de los juegos
    //@Query("SELECT * FROM PLAYER WHERE JUEGOPLAYER LIKE :juego")
    List<Player> getNoticias(String juego);



}
