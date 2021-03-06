package com.example.administrator.maimengcartoon.adapter.mengwoadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016-12-16.
 */

public class MengWoViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String TITLE[]=new String[]{"资讯","漫画","美图","礼包"};

    public MengWoViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
