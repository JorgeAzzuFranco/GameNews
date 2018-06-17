package com.includeazzu.gamenews.DBRoom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.includeazzu.gamenews.POJO.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiasDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME="bd_noticias";
    public static final String TABLA_DB = "noticia";
    public static final String CAMPO_ID = "idNoticia";
    public static final String CAMPO_TITULONOTICIA = "tituloNoticia";
    public static final String CAMPO_IMAGENNOTICIA = "imagenNoticia";
    public static final String CAMPO_FECHANOTICIA = "fechaNoticia";
    public static final String CAMPO_DESCNOTICIA = "descNoticia";
    public static final String CAMPO_CUERPONOTICIA = "cuerpoNoticia";
    public static final String CAMPO_JUEGO = "juego";
    public static final String CREATE_TABLA_NOTICIA = "CREATE TABLE " + TABLA_DB + "("+CAMPO_ID + " TEXT," +
            CAMPO_TITULONOTICIA + " TEXT," + CAMPO_IMAGENNOTICIA + " TEXT," + CAMPO_FECHANOTICIA + " TEXT," +
            CAMPO_DESCNOTICIA + " TEXT," + CAMPO_CUERPONOTICIA + " TEXT," +CAMPO_JUEGO +" TEXT)";



    public static NoticiasDatabase myDB = null;
    private Context context;
    SQLiteDatabase db;

    public static NoticiasDatabase getInstance(Context context) {
        if(myDB == null){
            myDB = new NoticiasDatabase(context);
        }
        return  myDB;
    }

    public NoticiasDatabase(Context context) {
        super(context, DB_NAME, null, 1);
        this.context=context;
        db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLA_NOTICIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_DB);
    }

    public boolean addNoticia(List<Noticia> n){
        ContentValues val = new ContentValues();

        for (int i = 0; i < n.size(); i++){
            val.put(CAMPO_ID, n.get(i).getIdNoticia());
            val.put(CAMPO_TITULONOTICIA, n.get(i).getTituloNoticia());
            val.put(CAMPO_IMAGENNOTICIA, n.get(i).getImagenNoticia());
            val.put(CAMPO_FECHANOTICIA, n.get(i).getFechaNoticia());
            val.put(CAMPO_DESCNOTICIA, n.get(i).getDescNoticia());
            val.put(CAMPO_CUERPONOTICIA, n.get(i).getCuerpoNoticia());
            val.put(CAMPO_JUEGO, n.get(i).getJuego());
            db.insert(TABLA_DB, null, val);
        }

        return true;
    }

    public boolean delNoticias(SQLiteDatabase db){
        db.execSQL("DELETE FROM " + TABLA_DB);
        return true;
    }

    public List<Noticia> getAll(SQLiteDatabase db){

        String[] campos = {CAMPO_ID, CAMPO_TITULONOTICIA, CAMPO_IMAGENNOTICIA,
        CAMPO_FECHANOTICIA, CAMPO_DESCNOTICIA, CAMPO_CUERPONOTICIA, CAMPO_JUEGO};
        Cursor cursor = db.query(TABLA_DB, campos, null, null,
                               null, null, null);

        List<Noticia> noti = new ArrayList<>();

        cursor.moveToFirst();

        while(cursor.moveToNext()){
            noti.add(new Noticia(cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),cursor.getString(5),
                    cursor.getString(6), cursor.getString(7)));
        }

        return noti;
    }

    public List<Noticia> getJuego(SQLiteDatabase db, String juego){

        String[] campos = {CAMPO_ID, CAMPO_TITULONOTICIA, CAMPO_IMAGENNOTICIA,
                CAMPO_FECHANOTICIA, CAMPO_DESCNOTICIA, CAMPO_CUERPONOTICIA, CAMPO_JUEGO};

        String whereClause = "column7 = ?";
        String[] arg = {juego};
        Cursor cursor = db.query(TABLA_DB, campos, whereClause, arg,
                null, null, null);

        List<Noticia> noti = new ArrayList<>();

        cursor.moveToFirst();

        while(cursor.moveToNext()){
            noti.add(new Noticia(cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),cursor.getString(5),
                    cursor.getString(6), cursor.getString(7)));
        }

        return noti;
    }




}
