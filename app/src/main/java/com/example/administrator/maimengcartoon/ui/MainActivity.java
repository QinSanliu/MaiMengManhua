package com.example.administrator.maimengcartoon.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.fragment.manhuafaragment.ManHuaFragment;
import com.example.administrator.maimengcartoon.fragment.meitufragments.MeiTuFragment;
import com.example.administrator.maimengcartoon.fragment.mengwofragment.MengWoFragment;
import com.example.administrator.maimengcartoon.fragment.zixunfragment.ZiXunFragment;
import com.example.administrator.maimengcartoon.utils.TabFragmentUtils;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = ((RadioGroup) findViewById(R.id.activity_main_radioGroupId));

        fragments=new ArrayList<>();
        fragments.add(new ZiXunFragment());
        fragments.add(new ManHuaFragment());
        fragments.add(new MeiTuFragment());
        fragments.add(new MengWoFragment());

        new TabFragmentUtils(radioGroup,fragments,R.id.activity_main_frameLayoutId,getSupportFragmentManager());
    }
}
