package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public class meizhoushoucangRecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen;
    private View view;

    public meizhoushoucangRecyclerAdapter(Context mContext, List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen) {
        this.mContext = mContext;
        this.cartoonSetListBeen = cartoonSetListBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.meizhoushoucang_item, parent, false);
       MeiZhouItemViewholder meiZhouItemViewholder = new MeiZhouItemViewholder(view);

        return meiZhouItemViewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MeiZhouItemViewholder holder1 = (MeiZhouItemViewholder) holder;
        String images = cartoonSetListBeen.get(position).getImages();
        if (images!=null) {
            Uri uri = Uri.parse(images);
            holder1.meizhoushoucang_item_6_simiamge.setImageURI(uri);
        }
        holder1.meizhoushoucang_item_6_name.setText(cartoonSetListBeen.get(position).getName());
        holder1.meizhoushoucang_item_6_zuozhe.setText(cartoonSetListBeen.get(position).getAuthor());
        holder1.meizhoushoucang_item_6_leixing.setText(cartoonSetListBeen.get(position).getCategoryLabel());
        holder1.meizhoushoucang_item_6_genxin.setText(cartoonSetListBeen.get(position).getUpdateInfo());

        switch (position) {
            case 0:
                holder1.meizhoushoucang_item_iamge.setImageResource(R.mipmap.image_most_collect_one);
                break;
             case 1:
                holder1.meizhoushoucang_item_iamge.setImageResource(R.mipmap.image_most_collect_two);
                break;
             case 2:
                holder1.meizhoushoucang_item_iamge.setImageResource(R.mipmap.image_most_collect_three);
                 view.setBottom(0);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return cartoonSetListBeen.size();
    }
    class MeiZhouItemViewholder extends RecyclerView.ViewHolder{
        SimpleDraweeView meizhoushoucang_item_6_simiamge;
        TextView meizhoushoucang_item_6_name;
        TextView meizhoushoucang_item_6_zuozhe;
        TextView meizhoushoucang_item_6_leixing;
        TextView meizhoushoucang_item_6_genxin;
        ImageView meizhoushoucang_item_iamge;
        public MeiZhouItemViewholder(View itemView) {
            super(itemView);
            meizhoushoucang_item_6_simiamge = (SimpleDraweeView) itemView.findViewById(R.id.meizhoushoucang_item_6_simiamge);
            meizhoushoucang_item_6_name = (TextView) itemView.findViewById(R.id.meizhoushoucang_item_6_name);
            meizhoushoucang_item_6_zuozhe = (TextView) itemView.findViewById(R.id.meizhoushoucang_item_6_zuozhe);
            meizhoushoucang_item_6_leixing = (TextView) itemView.findViewById(R.id.meizhoushoucang_item_6_leixing);
            meizhoushoucang_item_6_genxin = (TextView) itemView.findViewById(R.id.meizhoushoucang_item_6_genxin);
            meizhoushoucang_item_iamge = (ImageView) itemView.findViewById(R.id.meizhoushoucang_item_iamge);
        }
    }



}
