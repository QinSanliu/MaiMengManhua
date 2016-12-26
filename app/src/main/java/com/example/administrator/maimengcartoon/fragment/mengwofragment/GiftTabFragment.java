package com.example.administrator.maimengcartoon.fragment.mengwofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.maimengcartoon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GiftTabFragment extends Fragment {


    public GiftTabFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gift_tab, container, false);
        return view;
    }

}
