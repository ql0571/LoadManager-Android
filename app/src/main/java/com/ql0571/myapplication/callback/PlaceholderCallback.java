package com.ql0571.myapplication.callback;

import com.ql0571.loadmanager.callback.LoadCallback;
import com.ql0571.myapplication.R;


/**
 * desc:占位图页面
 * <p>
 * author: qiulie
 * date: 2017/9/30
 */
public class PlaceholderCallback extends LoadCallback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_placeholder;
    }
}
