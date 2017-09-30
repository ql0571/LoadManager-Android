package com.ql0571.myapplication.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ql0571.loadmanager.callback.LoadCallback;
import com.ql0571.loadmanager.core.LoadManager;
import com.ql0571.loadmanager.core.LoadService;
import com.ql0571.myapplication.R;
import com.ql0571.myapplication.callback.ErrorCallback;
import com.ql0571.myapplication.callback.LoadingCallback;


public class NormalFragment extends Fragment {

    private LoadService loadService;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = View.inflate(getActivity(), R.layout.fragment_a_content, null);
        loadService = LoadManager.getDefault().register(rootView, new LoadCallback.OnReloadListener() {
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

        return loadService.getLoadLayout();
    }

}