package com.ql0571.myapplication.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ql0571.loadmanager.callback.LoadCallback;
import com.ql0571.loadmanager.core.LoadManager;
import com.ql0571.loadmanager.core.LoadService;
import com.ql0571.myapplication.R;
import com.ql0571.myapplication.callback.ErrorCallback;
import com.ql0571.myapplication.callback.LoadingCallback;

public class NormalActivity extends AppCompatActivity {


    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        loadService = LoadManager.getDefault().register(this, new LoadCallback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadService.showCallback(LoadingCallback.class);
                        SystemClock.sleep(500);
                        loadService.showSuccess();
                    }
                }).start();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                loadService.showCallback(ErrorCallback.class);
            }
        }).start();
//        PostUtil.postCallbackDelayed(loadService,EmptyCallback.class);
    }

}
