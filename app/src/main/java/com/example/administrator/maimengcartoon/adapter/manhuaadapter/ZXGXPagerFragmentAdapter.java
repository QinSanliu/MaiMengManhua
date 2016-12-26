package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class ZXGXPagerFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> fragments;
    public ZXGXPagerFragmentAdapter(FragmentManager fm ,Context mContext,List<Fragment> fragments) {
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
        return fragments!=null?fragments.size():0;
    }


}
