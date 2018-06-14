package com.includeazzu.gamenews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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


        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        gameNewsAPI = ApiUtiles.getGameNewsAPI();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editUser = (EditText) findViewById(R.id.editUser);
                final EditText editPass = (EditText) findViewById(R.id.editPass);

                String user = editUser.getText().toString().trim();
                String pass = editPass.getText().toString().trim();

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    sendCredentials(user, pass);
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

                        Intent pasarANoticias = new Intent(getApplicationContext(), MainActivity.class);
                        pasarANoticias.putExtra("TOKEN", tokenSend);
                        startActivity(pasarANoticias);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Error", "Hubo error en algun lado");
                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.msj_err), Toast.LENGTH_SHORT).show();
                        TextView editPas = findViewById(R.id.editPass);
                        editPas.setText("");

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

        Log.i("PASE", "TOKEN: "+preferencias.getString("tokenpdm", "noToken"));

        return token.getToken();

    }
}

