package com.includeazzu.gamenews.DBRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.POJO.Usuario;

import java.util.List;

//@Dao
public interface UsuarioDAO {

    //@Query("SELECT * FROM USUARIO WHERE USER == :user")
    Usuario getUser(String user);


}
