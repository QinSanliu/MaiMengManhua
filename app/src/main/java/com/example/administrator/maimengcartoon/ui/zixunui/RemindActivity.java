package com.example.administrator.maimengcartoon.ui.zixunui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.maimengcartoon.R;

public class RemindActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);

        initView();

        fanhui.setOnClickListener(this);
    }

    private void initView() {
        fanhui = ((ImageView) findViewById(R.id.activity_remind_fanhui));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_remind_fanhui:
                finish();
                break;
        }
    }
}
