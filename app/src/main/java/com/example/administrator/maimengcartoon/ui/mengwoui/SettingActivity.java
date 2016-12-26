package com.example.administrator.maimengcartoon.ui.mengwoui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.maimengcartoon.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();

        fanhui.setOnClickListener(this);
    }

    private void initView() {
        fanhui = ((ImageView) findViewById(R.id.activity_setting_fanhui));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_setting_fanhui:
                finish();
                break;
        }
    }
}
