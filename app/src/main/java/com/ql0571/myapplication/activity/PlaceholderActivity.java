package com.ql0571.myapplication.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ql0571.loadmanager.core.LoadManager;
import com.ql0571.loadmanager.core.LoadService;
import com.ql0571.myapplication.R;
import com.ql0571.myapplication.callback.PlaceholderCallback;


public class PlaceholderActivity extends AppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);
        LoadManager loadManager = new LoadManager.Builder()
                .addCallback(new PlaceholderCallback())
                .setDefaultCallback(PlaceholderCallback.class)
                .build();
        loadService = loadManager.register(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                loadService.showSuccess();
            }
        }).start();
    }

}
