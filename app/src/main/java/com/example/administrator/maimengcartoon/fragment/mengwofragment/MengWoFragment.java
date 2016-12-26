package com.example.administrator.maimengcartoon.fragment.mengwofragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.mengwoadapter.MengWoViewPagerAdapter;
import com.example.administrator.maimengcartoon.ui.mengwoui.SettingActivity;
import com.example.administrator.maimengcartoon.ui.zixunui.RemindActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MengWoFragment extends Fragment implements View.OnClickListener {


    private TextView login;
    private TextView message;
    private TextView shop;
    private TextView ranking;
    private TextView setting;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> fragments;
    private MengWoViewPagerAdapter mengWoViewPagerAdapter;

    public MengWoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meng_wo, container, false);

        initView(view);

        fragments=new ArrayList<>();
        fragments.add(new ZiXunTabFragment());
        fragments.add(new CartoonTabFragment());
        fragments.add(new MeiTuTabFragment());
        fragments.add(new GiftTabFragment());

        //实例化适配器
        mengWoViewPagerAdapter = new MengWoViewPagerAdapter(getActivity().getSupportFragmentManager(),fragments);
        //设置适配器
        viewPager.setAdapter(mengWoViewPagerAdapter);

        //将TabLayout与viewPager关联
        tabLayout.setupWithViewPager(viewPager);

        message.setOnClickListener(this);
        setting.setOnClickListener(this);

        return view;
    }

    private void initView(View view) {
        login = ((TextView) view.findViewById(R.id.fragment_meng_wo_login));
        message = ((TextView) view.findViewById(R.id.fragment_meng_wo_message));
        shop = ((TextView) view.findViewById(R.id.fragment_meng_wo_shop));
        ranking = ((TextView) view.findViewById(R.id.fragment_meng_wo_ranking));
        setting = ((TextView) view.findViewById(R.id.fragment_meng_wo_setting));
        tabLayout = ((TabLayout) view.findViewById(R.id.fragment_meng_wo_tabLayout));
        viewPager = ((ViewPager) view.findViewById(R.id.fragment_meng_wo_viewPager));
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.fragment_meng_wo_message://消息
                intent=new Intent(getActivity(), RemindActivity.class);
                break;
            case R.id.fragment_meng_wo_shop://积分商城
                break;
            case R.id.fragment_meng_wo_ranking://封神榜
                break;
            case R.id.fragment_meng_wo_setting://设置
                intent=new Intent(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);
    }
}
