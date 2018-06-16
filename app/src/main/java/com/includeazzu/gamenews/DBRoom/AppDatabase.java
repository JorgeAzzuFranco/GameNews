package com.includeazzu.gamenews.DBRoom;



import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.POJO.Player;
import com.includeazzu.gamenews.POJO.Usuario;

//@Database(entities = {Noticia.class, Player.class, Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   private static AppDatabase INSTANCE;
   public abstract NoticiasDAO noticiasDAO();

   static AppDatabase getAppDatabase (final Context context){

       if (INSTANCE == null) {
           synchronized (AppDatabase.class) {
               if (INSTANCE == null) {
                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           AppDatabase.class, "word_database")
                           .addCallback(sRoomDatabaseCallback)
                           .build();
               }
           }
       }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

       @Override
       public void onOpen(@NonNull SupportSQLiteDatabase db) {
           super.onOpen(db);
       }
   };
}
