package com.example.administrator.maimengcartoon.fragment.manhuafaragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.adapter.manhuaadapter.ManHuaFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManHuaFragment extends Fragment {


    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private View view;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_man_hua, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.manhua_viewpager_fragment);
        mTabLayout = (TabLayout) view.findViewById(R.id.manhua_tablayout_fragment);
        intFragment();//设置fragment
        initAdapter();//设置适配器，tablayout之间的联动
        return view;
    }

    private void intFragment() {
        fragments.add(new TuiJianFragment());
        fragments.add(new ZhuanTiFragment());
        fragments.add(new LeiBieFragment());
        fragments.add(new ShuJiaFragment());

    }

    private void initAdapter() {

        ManHuaFragmentPagerAdapter manhuaadapter = new ManHuaFragmentPagerAdapter(getActivity().getSupportFragmentManager(),getContext(),fragments);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(manhuaadapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
