package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public class ZXGXRecyclerAdapter extends RecyclerView.Adapter {

    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen;
    private Context mContext;

    public ZXGXRecyclerAdapter(List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen, Context mContext) {
        this.cartoonSetListBeen = cartoonSetListBeen;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zuijingengxin_item_2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
            String imagesurl = cartoonSetListBeen.get(position).getImages();
            Log.d("flag", "onBindViewHolder: 获取图片地址"+imagesurl);
            if (imagesurl!=null){
                Uri uri = Uri.parse(imagesurl);
                myViewHolder.zuijingenxin_simle_image.setImageURI(uri);
                Log.d("flag", "onBindViewHolder: fresco设置图片成功");
            }
            myViewHolder.zuijingenxin_genxin_tv.setText(cartoonSetListBeen.get(position).getUpdateInfo());
            myViewHolder.zuijingenxin_name_tv.setText(cartoonSetListBeen.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cartoonSetListBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView zuijingenxin_simle_image;
        TextView zuijingenxin_genxin_tv;
        TextView zuijingenxin_name_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            zuijingenxin_simle_image = (SimpleDraweeView) itemView.findViewById(R.id.zuijingenxin_simle_image);
            zuijingenxin_name_tv = (TextView) itemView.findViewById(R.id.zuijingenxin_name_tv);
            zuijingenxin_genxin_tv = (TextView) itemView.findViewById(R.id.zuijingenxin_genxin_tv);

        }
    }
}
