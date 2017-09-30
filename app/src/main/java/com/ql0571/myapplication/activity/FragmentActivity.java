package com.ql0571.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ql0571.myapplication.R;
import com.ql0571.myapplication.fragment.NormalFragment;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_body, new NormalFragment()).commitAllowingStateLoss();

    }


}
