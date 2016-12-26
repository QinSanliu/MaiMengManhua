package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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

public class zuixinshangjiaandcannixihuanRecyclerAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen;

    public zuixinshangjiaandcannixihuanRecyclerAdapter(Context mContext, List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen) {
        this.mContext = mContext;
        this.cartoonSetListBeen = cartoonSetListBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cainixihuan_item_9, parent, false);
        ZxsjandcnxhItemViewHolder zxsjandcnxhItemViewHolder = new ZxsjandcnxhItemViewHolder(view);


        return zxsjandcnxhItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ZxsjandcnxhItemViewHolder holder1 = (ZxsjandcnxhItemViewHolder) holder;
        String images = cartoonSetListBeen.get(position).getImages();
        if (images!=null) {
            Uri uri = Uri.parse(images);
            holder1.cainixihuan_simle_image.setImageURI(uri);
        }
        holder1.cainixihuan_genxin_tv.setText(cartoonSetListBeen.get(position).getUpdateInfo());
        holder1.cainixihuan_name_tv.setText(cartoonSetListBeen.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return cartoonSetListBeen.size();
    }

    class ZxsjandcnxhItemViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView cainixihuan_simle_image;
        TextView cainixihuan_genxin_tv;
        TextView cainixihuan_name_tv;

        public ZxsjandcnxhItemViewHolder(View itemView) {
            super(itemView);
            cainixihuan_simle_image = (SimpleDraweeView) itemView.findViewById(R.id.cainixihuan_simle_image);
            cainixihuan_genxin_tv = (TextView) itemView.findViewById(R.id.cainixihuan_genxin_tv);
            cainixihuan_name_tv = (TextView) itemView.findViewById(R.id.cainixihuan_name_tv);

        }
    }

}
