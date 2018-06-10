package com.includeazzu.gamenews.POJO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "player")
public class Player {

    //@PrimaryKey(autoGenerate = true)
    @SerializedName("_id")
    @Expose
    private int idPlayer;

    //@ColumnInfo(name = "nombrePlayer")
    @SerializedName("name")
    @Expose
    private String nombrePlayer;

    //@ColumnInfo(name = "bioPlayer")
    @SerializedName("biografia")
    @Expose
    private String bioPlayer;

    //@ColumnInfo(name = "avatarPlayer")
    @SerializedName("avatar")
    @Expose
    private String avatarPlayer;

    //@ColumnInfo(name = "juegoPlayer")
    @SerializedName("game")
    @Expose
    private String juegoPlayer;

    //Constructor
    public Player(int idPlayer, String nombrePlayer, String bioPlayer, String avatarPlayer, String juegoPlayer) {
        this.idPlayer = idPlayer;
        this.nombrePlayer = nombrePlayer;
        this.bioPlayer = bioPlayer;
        this.avatarPlayer = avatarPlayer;
        this.juegoPlayer = juegoPlayer;
    }

    //Getters y Setters
    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNombrePlayer() {
        return nombrePlayer;
    }

    public void setNombrePlayer(String nombrePlayer) {
        this.nombrePlayer = nombrePlayer;
    }

    public String getBioPlayer() {
        return bioPlayer;
    }

    public void setBioPlayer(String bioPlayer) {
        this.bioPlayer = bioPlayer;
    }

    public String getAvatarPlayer() {
        return avatarPlayer;
    }

    public void setAvatarPlayer(String avatarPlayer) {
        this.avatarPlayer = avatarPlayer;
    }

    public String getJuegoPlayer() {
        return juegoPlayer;
    }

    public void setJuegoPlayer(String juegoPlayer) {
        this.juegoPlayer = juegoPlayer;
    }
}
