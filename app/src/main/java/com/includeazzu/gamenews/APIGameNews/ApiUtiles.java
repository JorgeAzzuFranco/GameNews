package com.includeazzu.gamenews.APIGameNews;

import retrofit2.Retrofit;

public class ApiUtiles {

    public ApiUtiles() {}

    public static final String ENDPOINT = "http://gamenewsuca.herokuapp.com/";

    public static GameNewsAPI getGameNewsAPI(){
        return retrofitClient.getClient(ENDPOINT).create(GameNewsAPI.class);
    }

}

