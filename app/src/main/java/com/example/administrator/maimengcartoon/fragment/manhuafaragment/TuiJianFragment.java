package com.example.administrator.maimengcartoon.fragment.manhuafaragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.manhuaadapter.TuiJianRVAdapter;
import com.example.administrator.maimengcartoon.adapter.zixunadapter.ZiXunHeadViewPagerAdapter;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianHeadBean;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/12.
 */

public class TuiJianFragment extends Fragment {

    private View view;
    private PullToRefreshRecyclerView mRecyclerView;
    private  String TUI_JIAN = AppInterface.Manhua.TUI_JIAN;
    private TuiJianRVAdapter myTuiJianRVAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View headerView;
    private ViewPager handviewpager;
    private LinearLayout linearLayout;
    private int currentPosition;//设置轮播标记
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (this.hasMessages(1)) {
                        //移出多个Message，保证只有一个
                        this.removeMessages(1);
                    }
                    currentPosition++;
                    handviewpager.setCurrentItem(currentPosition);
                    this.sendEmptyMessageDelayed(1, 3000);
                    break;
                case 2:
                    if (this.hasMessages(1)) {
                        //移出了Message，自动的切换就会停止
                        this.removeMessages(1);
                    }
                    break;
                case 3:
                    //手滑动的时候，页码变，需要对页码重新赋值
                    currentPosition = msg.arg1;
                    this.sendEmptyMessageDelayed(1, 3000);
                    break;
            }
        }
    };
    private RecyclerView recyclerView;
    private List<TuiJianBean.ResultsBean> results;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //添加头布局
        headerView = inflater.inflate(R.layout.tujian_item_headview, null);
        //当前主布局
        view = inflater.inflate(R.layout.manhua_tuijian_fragment, container, false);
        mRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.tuijian_fragment_recyclerview);
//        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);//这个模式设置上下拉刷新，不设置只能下拉刷新
        mRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                //下拉加载
                results.clear();
                initdata();
                mRecyclerView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
            }
        });
        recyclerView = mRecyclerView.getRefreshableView();
        initdata();
        Log.d("flag", "onCreateView: 网络下载地址"+TUI_JIAN);
        initRecyclerview();

        return view;
    }

    private void initdata() {
        OkHttpUtils.get().url(TUI_JIAN).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.d("flag", "onResponse: 网络下载数据"+response);
                Gson gson = new Gson();
                TuiJianBean tuiJianBean = gson.fromJson(response, TuiJianBean.class);
                results = tuiJianBean.getResults();
                Log.d("flag", "onResponse:解析数据"+ results.size());
                myTuiJianRVAdapter  = new TuiJianRVAdapter(getContext(), results,getChildFragmentManager());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                myTuiJianRVAdapter.addHeadView(headerView);
                recyclerView.setAdapter(myTuiJianRVAdapter);

            }
        });

    }

    private void initRecyclerview() {
        handviewpager = (ViewPager) headerView.findViewById(R.id.tuijianhead_viewPager);
        linearLayout = (LinearLayout) headerView.findViewById(R.id.tuijian_linearLayout);
        showAtPosition(0);
        loadImage();

    }

    private void showAtPosition(int position) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ImageView imageView = (ImageView) linearLayout.getChildAt(i);
            if (position % linearLayout.getChildCount() == i) {
                imageView.setImageResource(R.mipmap.ic_page_indicator_focused);
            } else {
                imageView.setImageResource(R.mipmap.ic_page_indicator);
            }
        }
    }

    private void loadImage() {
        OkHttpUtils.get().url(AppInterface.Manhua.TUI_JIAN_HAND).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                TuiJianHeadBean tuiJianHeadBean = gson.fromJson(response, TuiJianHeadBean.class);
                List<TuiJianHeadBean.ResultsBean> results = tuiJianHeadBean.getResults();
                //此处resuts里面有子数据
                //results.get（i）.
                intiheadview(results);
            }
        });


    }



    //头布局设置
    private void intiheadview(List<TuiJianHeadBean.ResultsBean> results) {

        ArrayList<View> viewList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.item_zixun_headimage, null);
            viewList.add(view);

            String images = results.get(i).getImages();
            String title = results.get(i).getTitle();
            ImageView imageView = (ImageView) view.findViewById(R.id.item_zixun_headimage_imageView);
            TextView textView = (TextView) view.findViewById(R.id.item_zixun_headimage_title);
            textView.setText(title);
            Picasso.with(getContext())
                    .load(images)
                    .placeholder(R.mipmap.jiazaitu)
                    .error(R.mipmap.jiazaitu)
                    .into(imageView);

        }
        //实例化适配器
        ZiXunHeadViewPagerAdapter viewPagerAdapter = new ZiXunHeadViewPagerAdapter(viewList);
        //设置适配器
        handviewpager.setAdapter(viewPagerAdapter);
        currentPosition = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % viewList.size();
        handviewpager.setCurrentItem(currentPosition);

        handler.sendEmptyMessageDelayed(1, 3000);
        handviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.sendMessage(Message.obtain(handler, 3, position, 0));
                showAtPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    handler.sendEmptyMessage(2);
                }
            }
        });

    }
}
