package com.ql0571.myapplication.callback;

import com.ql0571.loadmanager.callback.LoadCallback;
import com.ql0571.myapplication.R;


/**
 * desc:错误页面
 * <p>
 * author: qiulie
 * date: 2017/9/30
 */


public class EmptyCallback extends LoadCallback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }
}
