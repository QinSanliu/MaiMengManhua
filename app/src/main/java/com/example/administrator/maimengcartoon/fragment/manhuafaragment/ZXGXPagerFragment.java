package com.example.administrator.maimengcartoon.fragment.manhuafaragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.manhuaadapter.ZXGXRecyclerAdapter;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class ZXGXPagerFragment extends Fragment {


    private View view;
    private RecyclerView mRecyclerView;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen;
    private int position;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Bundle bundle= getArguments();
        ArrayList list = bundle.getParcelableArrayList("cartoonSetList");
        cartoonSetListBeen = (List<TuiJianBean.ResultsBean.CartoonSetListBean>) list.get(0);
        position = bundle.getInt("myi");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.zuixingenxin_viewpager_item,container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.zuijingengxin_pager_recyclerview);
        Log.d("flag", "onCreateView: 到达最新更新"+view);
        initdata();
        return view;
    }
//设置fragment填充物
    private void initdata() {
        ZXGXRecyclerAdapter recyclerAdapter = new ZXGXRecyclerAdapter(cartoonSetListBeen,getContext());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView.setAdapter(recyclerAdapter);

    }
}
