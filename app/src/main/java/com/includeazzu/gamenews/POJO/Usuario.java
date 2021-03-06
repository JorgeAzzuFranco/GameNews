package com.includeazzu.gamenews.POJO;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//@Entity(tableName = "usuario")
public class Usuario {

    //@PrimaryKey(autoGenerate = true)
    @SerializedName("_id")
    @Expose
    private int idUser;

    //@ColumnInfo(name = "user")
    @SerializedName("user")
    @Expose
    private String user;

    //@ColumnInfo(name = "password")
    @SerializedName("password")
    @Expose
    private String passUser;

    //@ColumnInfo(name = "noticiasFav")
    @SerializedName("favoriteNews")
    @Expose
    private List<Noticia> noticiasFavUser;

    //Constructor
    public Usuario(int idUser, String user, String passUser, List<Noticia> noticiasFavUser) {
        this.idUser = idUser;
        this.user = user;
        this.passUser = passUser;
        this.noticiasFavUser = noticiasFavUser;
    }


    //Getters y Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public List<Noticia> getNoticiasFavUser() {
        return noticiasFavUser;
    }

    public void setNoticiasFavUser(List<Noticia> noticiasFavUser) {
        this.noticiasFavUser = noticiasFavUser;
    }
}
