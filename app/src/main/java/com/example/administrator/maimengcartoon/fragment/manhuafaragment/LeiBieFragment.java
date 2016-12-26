package com.example.administrator.maimengcartoon.fragment.manhuafaragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.manhuaadapter.LeiBieRVAdapter;
import com.example.administrator.maimengcartoon.bean.manhuabeans.LeiBieBean;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/12.
 */
public class LeiBieFragment extends Fragment {

    private PullToRefreshRecyclerView mRecyclerView;
    private String url_one= AppInterface.Manhua.LEI_BIE_ONE;
    private String url_tow= AppInterface.Manhua.LEI_BIE_TOW;
    private int page = 1;
    private List<LeiBieBean.ResultsBean> results;
    private RecyclerView recyclerView;
    private LeiBieRVAdapter leiBieRVAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manhua_leibie_fragment, container, false);
        mRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.leibie_fragment_recyclerview);
        recyclerView = mRecyclerView.getRefreshableView();
        initdata();
        initRefresh();
        return view;
    }
    //设置上下拉刷新
    private void initRefresh() {
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                results.clear();
                leiBieRVAdapter.clear();
                page = 1;
                isflag = true;
                initdata();


            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                ++page;
                initdata();
            }
        });

    }

    private boolean isflag = true;
    //加载数据
    private void initdata() {
        OkHttpUtils.get().url(url_one+page+url_tow).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.d("flag", "onResponse: 数据加载"+response);
                if (response!=null) {
                    Gson gson = new Gson();
                    LeiBieBean leiBieBean = gson.fromJson(response, LeiBieBean.class);
                    results = leiBieBean.getResults();
                    if (isflag) {
                        initView(results);
                        isflag = false;
                    }else {
                        leiBieRVAdapter.addAll(results);
                    }

                }else {
                    Toast.makeText(getContext(),"数据加载完了！",Toast.LENGTH_SHORT).show();
                }
                mRecyclerView.onRefreshComplete();
            }
        });

    }
    //设置适配器
    private void initView(List<LeiBieBean.ResultsBean> results) {
        Log.d("flag", "initView: 设置适配器的数据"+results.size());
        leiBieRVAdapter = new LeiBieRVAdapter(results,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(leiBieRVAdapter);
    }
}
