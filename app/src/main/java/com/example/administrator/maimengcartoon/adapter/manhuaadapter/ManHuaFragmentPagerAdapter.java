package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ManHuaFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private int COUNT = 4;
    private String[] tabName= {"推荐","专题","类别","书架"};
    private Context mContext;

    public ManHuaFragmentPagerAdapter(FragmentManager fm, Context mContext,List<Fragment> fragments) {
        super(fm);
        this.mContext = mContext;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }
}
