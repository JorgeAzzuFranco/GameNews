package com.includeazzu.gamenews.POJO;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "noticia")
public class Noticia {

   //@PrimaryKey(autoGenerate = true)
   @SerializedName("_id")
   @Expose
    private String idNoticia;

    //@ColumnInfo(name = "titulo")
    @SerializedName("title")
    @Expose
    private String tituloNoticia;

    //@ColumnInfo(name = "coverImage")
    @SerializedName("coverImage")
    @Expose
    private String imagenNoticia;

    //@ColumnInfo(name = "fecha")
    @SerializedName("create_date")
    @Expose
    private String fechaNoticia;

    //@ColumnInfo(name = "descripcion")
    @SerializedName("description")
    @Expose
    private String descNoticia;

    //@ColumnInfo(name = "body")
    @SerializedName("body")
    @Expose
    private String cuerpoNoticia;

   //@ColumnInfo(name = "juego")
    @SerializedName("game")
    @Expose
    private String juego;

    /*@SerializedName("__v")
    @Expose
    private int v;*/

    //Constructor
    public Noticia(String idNoticia, String tituloNoticia, String imagenNoticia, String fechaNoticia, String descNoticia, String cuerpoNoticia, String juego) {
        this.idNoticia = idNoticia;
        this.tituloNoticia = tituloNoticia;
        this.imagenNoticia = imagenNoticia;
        this.fechaNoticia = fechaNoticia;
        this.descNoticia = descNoticia;
        this.cuerpoNoticia = cuerpoNoticia;
        this.juego = juego;
    }

    //Setters y Getters

    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getImagenNoticia() {
        return imagenNoticia;
    }

    public void setImagenNoticia(String imagenNoticia) {
        this.imagenNoticia = imagenNoticia;
    }

    public String getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(String fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    public String getDescNoticia() {
        return descNoticia;
    }

    public void setDescNoticia(String descNoticia) {
        this.descNoticia = descNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    /*public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }*/
}
