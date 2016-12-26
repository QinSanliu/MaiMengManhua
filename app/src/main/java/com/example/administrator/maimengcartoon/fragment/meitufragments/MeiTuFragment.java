package com.example.administrator.maimengcartoon.fragment.meitufragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.meitu_adapters.MeituRecyclerViewAdapter;
import com.example.administrator.maimengcartoon.bean.meitu.MeituEntity;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeiTuFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RecyclerView meituRecyclerView;
    private PullToRefreshRecyclerView meituPTRRecyclerView;
    private MeituRecyclerViewAdapter meituRecyclerViewAdapter;
    private ImageButton backToTop;
    private ImageView xialaImage,meitu_uploadhistory,meitu_tianjia;
    private View secondView;
    private View recyclerContainer;
    private RadioGroup meituRadioGroup;
    private EditText meituEditTextSearch;

    private int page = 0;

    public MeiTuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_mei_tu, container, false);
        initView(ret);

        loadData();

        initMeituRecyclerView();

        initBackTop(ret);

        meitu_tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "美图添加按钮", Toast.LENGTH_SHORT).show();
            }
        });
        meitu_uploadhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "美图上传历史按钮", Toast.LENGTH_SHORT).show();
            }
        });
        //四个按钮的点击变化颜色监听
        meituRadioGroup.setOnCheckedChangeListener(this);
        //下拉更多，展示第二个视图（更多标签视图）
        xialaImage.setOnClickListener(this);

        //搜索框
        initSearchInput();

        return ret;
    }

    private void initSearchInput() {
        String searchContent = meituEditTextSearch.getText().toString();

    }


    private void initBackTop(View ret) {
        backToTop = (ImageButton) ret.findViewById(R.id.meitu_back_top);
        backToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meituRecyclerView.smoothScrollToPosition(0);//回到顶部
            }
        });
    }

    private void initMeituRecyclerView() {
        meituRecyclerView = meituPTRRecyclerView.getRefreshableView();
        //RecyclerView设置瀑布流效果
        meituRecyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        meituRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        //设置meituRecyclerView适配器
        meituRecyclerViewAdapter = new MeituRecyclerViewAdapter(mData,getContext());
        meituRecyclerView.setAdapter(meituRecyclerViewAdapter);

    }

    public String labelName = "全部";
    private List<MeituEntity.ResultsBean> mData;
    public String meituUrl="http://api.playsm.com/index.php?&lastCount=40010&page=1&r=prettyImages%2Flist&size=10&";
    private void loadData() {
        mData = new ArrayList<>();
        OkHttpUtils.get().url(meituUrl).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        MeituEntity meituEntityBean = new Gson().fromJson(response, MeituEntity.class);
                        List<MeituEntity.ResultsBean> meituResultsBeanList = meituEntityBean.getResults();
                        for (int i = 0; i < meituResultsBeanList.size(); i++) {
                            MeituEntity.ResultsBean resultsBean = meituResultsBeanList.get(i);
                            mData.add(resultsBean);
                        }
                        meituPTRRecyclerView.onRefreshComplete();
                        meituRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.meitu_xiala:
                if (flag){
                    flag = true;
                }else {
                    flag = false;
                }
                break;
        }
        loadData();
        initMeituRecyclerView();
        upAndDown();

    }




    //控制视图切换的下拉按钮功能
    public boolean flag = true;
    public void upAndDown() {
        if (flag){
//            Toast.makeText(getContext(), "展开", Toast.LENGTH_SHORT).show();
            //控制向下向上按钮反转
            xialaImage.setImageResource(R.mipmap.shangla);
            flag = false;
            //两个视图切换显示
            recyclerContainer.setVisibility(View.GONE);
            secondView.setVisibility(View.VISIBLE);
        }else {
//            Toast.makeText(getContext(), "关闭", Toast.LENGTH_SHORT).show();
            xialaImage.setImageResource(R.mipmap.xiangxiala);
            flag = true;
            secondView.setVisibility(View.GONE);
            recyclerContainer.setVisibility(View.VISIBLE);
        }
    }

    //四个按钮的点击颜色变化（全部、插画、大触、其他）
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if (radioButton.getId()== checkedId) {
                radioButton.setBackgroundResource(R.drawable.meitu_bg_checked);
                radioButton.setTextColor(Color.parseColor("#dc143c"));
//                labelName = radioButton.getText().toString();
//                Toast.makeText(getContext(), labelName, Toast.LENGTH_SHORT).show();

                if (radioButton.getText().toString().equals("全部")){
                    Toast.makeText(getContext(), radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                    meituUrl = "http://api.playsm.com/index.php?&lastCount=40010&page=2&r=prettyImages%2Flist&size=10&";
                    loadData();
                    initMeituRecyclerView();
                }else {
                    Toast.makeText(getContext(), radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                    labelName = radioButton.getText().toString();
                    meituUrl = AppInterface.MEITU_URL_ONE+labelName+AppInterface.MEITU_URL_TWO;
                    loadData();
                    initMeituRecyclerView();
                }
            }else{
                radioButton.setBackgroundResource(R.drawable.meitu_bg_no_checked);
                radioButton.setTextColor(Color.parseColor("#404040"));
            }
        }
    }

    private void initView(View view) {

        meituRadioGroup = ((RadioGroup) view.findViewById(R.id.meitu_radioGroup));
        //RecyclerView
        meituPTRRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.meitu_PTR_RecyclerView);
        //下拉按钮——显示全部标签，&顶部 添加按、，上传文件按钮
        xialaImage = (ImageView) view.findViewById(R.id.meitu_xiala);
        meitu_tianjia = (ImageView) view.findViewById(R.id.meitu_tianjia);
        meitu_uploadhistory = (ImageView) view.findViewById(R.id.meitu_uploadhistory);
        //显示所有标签的视图，包含着RecyclerView的布局视图
        secondView = view.findViewById(R.id.meitu_second_view);
        recyclerContainer = view.findViewById(R.id.meitu_recycler_container);

        meituEditTextSearch = (EditText) view.findViewById(R.id.meitu_ET_searchInput);
    }
}
