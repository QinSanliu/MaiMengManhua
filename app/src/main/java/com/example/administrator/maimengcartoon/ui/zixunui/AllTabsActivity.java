package com.example.administrator.maimengcartoon.ui.zixunui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.zixunadapter.ZiXunAllTabsAdapter;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunTabEntrity;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class AllTabsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private List<ZiXunTabEntrity.ResultsBean> datas;
    private ZiXunAllTabsAdapter ziXunAllTabsAdapter;
    private int pager=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tabs);

        datas=new ArrayList<>();

        initView();

        pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                datas.clear();
                pager=1;
                loadData(pager);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                pager+=1;
                loadData(pager);
            }
        });

        RecyclerView recyclerView = pullToRefreshRecyclerView.getRefreshableView();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //实例化适配器
        ziXunAllTabsAdapter = new ZiXunAllTabsAdapter(this,datas);
        //设置适配器
        recyclerView.setAdapter(ziXunAllTabsAdapter);
        //加载数据
        loadData(pager);
    }

    private void loadData(int pager) {
        String url = String.format(AppInterface.ZI_XUN_TABS_URL, pager);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                ZiXunTabEntrity ziXunTabEntrity = new Gson().fromJson(response, ZiXunTabEntrity.class);
                List<ZiXunTabEntrity.ResultsBean> results = ziXunTabEntrity.getResults();
                datas.addAll(results);
                ziXunAllTabsAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        fanhui = ((ImageView) findViewById(R.id.activity_all_tabs_fanhui));
        pullToRefreshRecyclerView = ((PullToRefreshRecyclerView) findViewById(R.id.activity_all_tabs_recyclerView));

        fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
