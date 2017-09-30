package com.ql0571.myapplication;

import android.app.Application;
import android.support.v4.app.LoaderManager;

import com.ql0571.loadmanager.core.LoadManager;
import com.ql0571.myapplication.callback.ErrorCallback;
import com.ql0571.myapplication.callback.LoadingCallback;

/**
 * desc:
 * <p>
 * author: qiulie
 * date: 2017/9/30
 */

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LoadManager.beginBuilder()
                .addCallback(new LoadingCallback())
                .addCallback(new ErrorCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
