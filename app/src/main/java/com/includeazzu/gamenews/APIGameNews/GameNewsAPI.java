package com.includeazzu.gamenews.APIGameNews;


import com.includeazzu.gamenews.POJO.Noticia;
import com.includeazzu.gamenews.POJO.Token;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface GameNewsAPI {

    //Obteniendo token
    @POST("/login")
    @FormUrlEncoded
    Observable<Token> saveToken(@Field("user") String user,
                                @Field("password") String pass);

    //Fin de LogIn

    //Para las noticias
    //Lista de noticias
    @GET("/news")
    Call<List<Noticia>> getNoticias(@Header("Authorization: ") String token);

    //Fin de noticias

    //
}
