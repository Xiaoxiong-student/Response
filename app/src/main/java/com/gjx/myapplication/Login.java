package com.gjx.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Login extends AppCompatActivity{

    private  Button button;
    private EditText editText,editText1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        final String username = editText.getText().toString();
        final String password1 = editText1.getText().toString();
        button = findViewById(R.id.bt_login);

        editText = findViewById(R.id.et_pwd);

        editText1 = findViewById(R.id.et_username);

        

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        String url="https://www.baidu.com";

                        OkHttpClient httpClient = new OkHttpClient();
                        FormBody body = new FormBody.Builder()
                                .add("uname",username)
                                .add("password", password1).build();
                        Request request = new Request
                                .Builder()
                                .url(url)
                                .post(body)
                                .build();
                        try {
                            Response response = httpClient.newCall(request).execute();
                            Log.d("Response", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }
        });

    }

    }

