package com.afs.crashhandler;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity=======";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_make_main_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = null;
                String lowerCase = string.toLowerCase();
            }
        });
        findViewById(R.id.btn_make_thread_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        Log.d(TAG, "currentThread: name=" + Thread.currentThread().getName());
                        String string = null;
                        String lowerCase = string.toLowerCase();
                    }
                }.start();

            }
        });
        Log.d(TAG, "currentThread: name=" + Thread.currentThread().getName());
    }
}