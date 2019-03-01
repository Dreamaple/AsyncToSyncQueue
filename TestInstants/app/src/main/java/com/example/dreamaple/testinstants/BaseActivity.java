package com.example.dreamaple.testinstants;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    public BaseActivity instance;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Message m = Message.obtain();
            }
        });
        View view = new View(this);
        view.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
