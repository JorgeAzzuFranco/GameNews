package com.includeazzu.gamenews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.includeazzu.gamenews.APIGameNews.ApiUtiles;
import com.includeazzu.gamenews.APIGameNews.GameNewsAPI;
import com.includeazzu.gamenews.POJO.Token;

import java.lang.ref.PhantomReference;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    Button btnEntrar;
    GameNewsAPI gameNewsAPI;
    SharedPreferences preferencias = null;
    SharedPreferences.Editor prefEditor = null;
    String tokenSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editUser = (EditText) findViewById(R.id.editUser);
        final EditText editPass = (EditText) findViewById(R.id.editPass);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        gameNewsAPI = ApiUtiles.getGameNewsAPI();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editUser.getText().toString().trim();
                String pass = editPass.getText().toString().trim();

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    sendCredentials(user, pass);

                    Intent pasarANoticias = new Intent(getApplicationContext(), MainActivity.class);
                    pasarANoticias.putExtra("TOKEN", tokenSend);
                    startActivity(pasarANoticias);
                }
            }
        });
    }

    public void sendCredentials(final String user, final String pass) {

        gameNewsAPI.saveToken(user, pass).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.msj_suc), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.msj_err), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNext(Token token) {
                        tokenSend = guardarToken(token);
                        //Toast.makeText(LoginActivity.this, token.toString()+"", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private String guardarToken(Token token) {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEditor = preferencias.edit();


        prefEditor.putString("tokenpdm", token.getToken());

        prefEditor.commit();

        return token.getToken();

    }
}

