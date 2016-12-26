package com.example.administrator.maimengcartoon.fragment.zixunfragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.example.administrator.maimengcartoon.adapter.zixunadapter.ZiXunHeadViewPagerAdapter;
import com.example.administrator.maimengcartoon.adapter.zixunadapter.ZiXunRVAdapter;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunListEntrity;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunSubjectEntrity;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunTabEntrity;
import com.example.administrator.maimengcartoon.ui.zixunui.MoreSubjectActivity;
import com.example.administrator.maimengcartoon.ui.zixunui.RemindActivity;
import com.example.administrator.maimengcartoon.ui.zixunui.ZiXunHeadWebViewActivity;
import com.example.administrator.maimengcartoon.uri.AppInterface;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiXunFragment extends Fragment implements View.OnClickListener {


    private ImageView remind;
    private ImageView search;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private ZiXunRVAdapter ziXunRVAdapter;

    private List<ZiXunListEntrity.ResultsBean> datas;
    private List<ZiXunTabEntrity.ResultsBean> data;
    private List<ZiXunTabEntrity.ResultsBean> tabDatas;

    private int page = 0;
    private View headerView;
    private ViewPager viewPager;
    private SimpleDraweeView classical;
    private SimpleDraweeView bufan;
    private ImageView moreSubject;
    private ZiXunHeadViewPagerAdapter viewPagerAdapter;

    private LinearLayout linearLayout;
    private int currentPosition;

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
                    viewPager.setCurrentItem(currentPosition);
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
    private String content;
    private String images;
    private String title;

    public ZiXunFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zi_xun, container, false);

        datas = new ArrayList<>();
        tabDatas = new ArrayList<>();
        data = new ArrayList<>();

        initView(view);

        RecyclerView recyclerView = pullToRefreshRecyclerView.getRefreshableView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //实例化适配器
        ziXunRVAdapter = new ZiXunRVAdapter(datas, tabDatas, data, getContext());

        //添加头布局
        headerView = inflater.inflate(R.layout.item_zi_xun_head, null);

        //实例化适配器
        initHeaderView();

        ziXunRVAdapter.addHeaderView(headerView);

        //设置适配器
        recyclerView.setAdapter(ziXunRVAdapter);
        //加载数据
        loadData(page);
        loadTabData();

        pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                datas.clear();
                page = 0;
                loadData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                page += 10;
                loadData(page);
            }
        });

        remind.setOnClickListener(this);
        search.setOnClickListener(this);

        return view;
    }

    private View view;
    private List<View> viewList;

    private void initHeaderView() {
        viewPager = ((ViewPager) headerView.findViewById(R.id.item_zi_xun_head_viewPager));
        linearLayout = ((LinearLayout) headerView.findViewById(R.id.item_zi_xun_head_linearLayout));

        classical = ((SimpleDraweeView) headerView.findViewById(R.id.item_zi_xun_head_classical));
        bufan = ((SimpleDraweeView) headerView.findViewById(R.id.item_zi_xun_head_bufan));
        moreSubject = ((ImageView) headerView.findViewById(R.id.item_zi_xun_head_moreSubject));

        viewList = new ArrayList<>();
        for (int i = 0; i <4; i++) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_zixun_headimage, null);
            viewList.add(view);
        }

        loadSubjectImage();
        loadImage();

        //实例化适配器
        viewPagerAdapter = new ZiXunHeadViewPagerAdapter(viewList);
        //设置适配器
        viewPager.setAdapter(viewPagerAdapter);

        currentPosition = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % viewList.size();
        viewPager.setCurrentItem(currentPosition);

        handler.sendEmptyMessageDelayed(1, 3000);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        showAtPosition(0);

        moreSubject.setOnClickListener(this);
    }
    private void loadImage() {
        OkHttpUtils.get().url(AppInterface.ZI_XUN_IMAGE_URL).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray results = jsonObject.optJSONArray("results");
                    jsonObject = results.optJSONObject(0);
                    JSONObject messageinfo = jsonObject.optJSONObject("messageinfo");
                    content = messageinfo.optString("content");
                    images = jsonObject.optString("images");
                    title = jsonObject.optString("title");
                    for (int i = 0; i < viewList.size(); i++) {
                        ImageView imageView = (ImageView)viewList.get(i).findViewById(R.id.item_zixun_headimage_imageView);
                        TextView textView = (TextView) viewList.get(i).findViewById(R.id.item_zixun_headimage_title);
                        textView.setText(title);

                        Picasso.with(getContext())
                                .load(images)
                                .placeholder(R.mipmap.jiazaitu)
                                .error(R.mipmap.jiazaitu)
                                .into(imageView);

                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent=new Intent(getContext(), ZiXunHeadWebViewActivity.class);
                                intent.putExtra("content", content);
                                intent.putExtra("title", title);
                                startActivity(intent);
                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadSubjectImage() {
        OkHttpUtils.get().url(AppInterface.ZI_XUN_SUBJECT_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                ZiXunSubjectEntrity ziXunSubjectEntrity = new Gson().fromJson(response, ZiXunSubjectEntrity.class);
                List<ZiXunSubjectEntrity.ResultsBean> results = ziXunSubjectEntrity.getResults();
                String bufanImage = results.get(0).getImages();
                String classicalImage = results.get(1).getImages();

                Uri bufanUri = Uri.parse(bufanImage);
                Uri classicalUri = Uri.parse(classicalImage);

                bufan.setImageURI(bufanUri);
                classical.setImageURI(classicalUri);
            }
        });
    }

    private String tab="r=messageTags%2Flist&size=60";
    private void loadTabData() {
        String url=String.format(AppInterface.ZI_XUN_TABS_URL,1)+tab;
        Log.d("1608", "---------------->loadTabData: "+url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                ZiXunTabEntrity ziXunTabEntrity = new Gson().fromJson(response, ZiXunTabEntrity.class);
                final List<ZiXunTabEntrity.ResultsBean> results = ziXunTabEntrity.getResults();
                for (int i = 0; i < 4; i++) {
                    ZiXunTabEntrity.ResultsBean resultsBean = results.get(i);
                    data.add(resultsBean);
                }
                for (int i = 0; i < 12; i++) {
                    ZiXunTabEntrity.ResultsBean resultsBean = results.get(i);
                    tabDatas.add(resultsBean);
                }
                ziXunRVAdapter.notifyDataSetChanged();

            }
        });
    }

    private void loadData(final int page) {
        OkHttpUtils.get().url(AppInterface.ZI_XUN_LIST_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                ZiXunListEntrity ziXunListEntrity = new Gson().fromJson(response, ZiXunListEntrity.class);
                List<ZiXunListEntrity.ResultsBean> results = ziXunListEntrity.getResults();
                for (int i = page; i < 10 + page; i++) {
                    ZiXunListEntrity.ResultsBean resultsBean = results.get(i);
                    datas.add(resultsBean);
                }
                pullToRefreshRecyclerView.onRefreshComplete();
                ziXunRVAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView(View view) {
        remind = ((ImageView) view.findViewById(R.id.fragment_zi_xun_remind));
        search = ((ImageView) view.findViewById(R.id.fragment_zi_xun_search));
        pullToRefreshRecyclerView = ((PullToRefreshRecyclerView) view.findViewById(R.id.fragment_zi_xun_pullToRefreshRecyclerView));
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.fragment_zi_xun_remind:
                 intent= new Intent(getActivity(), RemindActivity.class);
                break;
            case R.id.fragment_zi_xun_search:

                break;
            case R.id.item_zi_xun_head_moreSubject:
                intent=new Intent(getActivity(), MoreSubjectActivity.class);
                break;
        }
        startActivity(intent);
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
}