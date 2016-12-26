package com.example.administrator.maimengcartoon.ui.zixunui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.zixunadapter.MoreSubjectRVAdapter;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunSubjectEntrity;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MoreSubjectActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;
    private RecyclerView recyclerView;
    private List<ZiXunSubjectEntrity.ResultsBean> listDatas;
    private List<ZiXunSubjectEntrity.ResultsBean> gridDatas;
    private MoreSubjectRVAdapter moreSubjectRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_subject);

        listDatas=new ArrayList<>();
        gridDatas=new ArrayList<>();

        initView();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //实例化适配器
        moreSubjectRVAdapter = new MoreSubjectRVAdapter(this,listDatas,gridDatas);
        //设置适配器
        recyclerView.setAdapter(moreSubjectRVAdapter);
        //加载数据
        loadData();

        fanhui.setOnClickListener(this);
    }

    private void loadData() {
        OkHttpUtils.get().url(AppInterface.ZI_XUN_SUBJECT_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                ZiXunSubjectEntrity ziXunSubjectEntrity = new Gson().fromJson(response, ZiXunSubjectEntrity.class);
                List<ZiXunSubjectEntrity.ResultsBean> results = ziXunSubjectEntrity.getResults();
                for (int i = 2; i < 5; i++) {
                    listDatas.add(results.get(i));
                }
                gridDatas.add(results.get(0));
                gridDatas.add(results.get(1));
                for (int i = 5; i < 29; i++) {
                    gridDatas.add(results.get(i));
                }
                moreSubjectRVAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        fanhui = ((ImageView) findViewById(R.id.activity_more_subject_fanhui));
        recyclerView = ((RecyclerView) findViewById(R.id.activity_more_subject_recyclerView));
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
