package com.example.administrator.maimengcartoon.fragment.manhuafaragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.manhuaadapter.ZhuanTiRVAdapter;
import com.example.administrator.maimengcartoon.bean.manhuabeans.ZhuanTiBean;
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
public class ZhuanTiFragment extends Fragment {
    private PullToRefreshRecyclerView mRecyclerView;
    private RecyclerView recyclerView;
    private int page = 1;
    private  String url_path_one = AppInterface.Manhua.ZHUAN_TI;
    private  String url_path_tow = AppInterface.Manhua.ZHUAN_TI_TOW;
    private ZhuanTiRVAdapter zhuanTiRVAdapter;
    private List<ZhuanTiBean.ResultsBean> results;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.manhua_zhuanti_fragment, container, false);
        mRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.zhuanti_fragment_recycler);
        recyclerView = mRecyclerView.getRefreshableView();
        intdata();
        initRefresh();
        return view;
    }
    private boolean isflag = true;
    //加载数据
    private void intdata() {
        OkHttpUtils.get().url(url_path_one+page+url_path_tow).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                ZhuanTiBean zhuanTiBean = gson.fromJson(response, ZhuanTiBean.class);
                results = zhuanTiBean.getResults();

                if (response!=null){
                if (isflag) {
                    initView(results);
                    isflag = false;
                }else {
                    zhuanTiRVAdapter.addAll(results);
                }
                }else {
                    Toast.makeText(getContext(),"没有更多数据了！",Toast.LENGTH_SHORT).show();
                }

                mRecyclerView.onRefreshComplete();

            }
        });
    }


    //设置专题的适配器
    private void initView(List<ZhuanTiBean.ResultsBean> results) {
        zhuanTiRVAdapter = new ZhuanTiRVAdapter(getContext(),results);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
       layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
           @Override
           public int getSpanSize(int position) {
               switch (zhuanTiRVAdapter.getItemViewType(position)) {
                   case 0:
                       return 1;
                   case 1:
                      return 2;
                   default:
                       return -1;
               }
           }
       });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(zhuanTiRVAdapter);

    }
    //上下拉刷新
    private void initRefresh() {
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                page = 1;
                isflag = true;
                zhuanTiRVAdapter.clear();
                intdata();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
               results.clear();
                ++page;
                intdata();

            }
        });
    }

}
