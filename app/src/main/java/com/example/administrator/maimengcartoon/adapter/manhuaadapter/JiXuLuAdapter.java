package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class JiXuLuAdapter extends BaseAdapter {
    private Context mContext;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetLists;

    public JiXuLuAdapter(Context mContext,List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetLists) {
        this.mContext = mContext;
        this.cartoonSetLists = cartoonSetLists;
    }

    @Override
    public int getCount() {
        return cartoonSetLists!=null?cartoonSetLists.size():0;
    }

    @Override
    public Object getItem(int i) {
        return cartoonSetLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view==null) {
            holder = new MyViewHolder();
            holder.jixulu_simle_image = (SimpleDraweeView) view.findViewById(R.id.jixulu_simle_image);
            holder.jixulu_genxin_tv = (TextView) view.findViewById(R.id.jixulu_genxin_tv);
            holder.jixulu_name_tv = (TextView) view.findViewById(R.id.jixulu_name_tv);
            holder.jixulu_dangqian_tv = (TextView) view.findViewById(R.id.jixulu_dangqian_tv);
            view.setTag(holder);
        }else{

             holder= (MyViewHolder) view.getTag();
        }
        //加载数据

        return view;
    }
    class MyViewHolder{
        SimpleDraweeView jixulu_simle_image;
        TextView jixulu_genxin_tv;
        TextView jixulu_name_tv;
        TextView jixulu_dangqian_tv;
    }
}
