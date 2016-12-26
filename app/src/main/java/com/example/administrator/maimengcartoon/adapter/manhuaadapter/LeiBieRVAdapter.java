package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.manhuabeans.LeiBieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */

public class LeiBieRVAdapter extends RecyclerView.Adapter {
    private List<LeiBieBean.ResultsBean> resultsBeen;
    private Context mContext;
    private List<LeiBieBean.ResultsBean> mResultsBeen= new ArrayList<>();

    public LeiBieRVAdapter(List<LeiBieBean.ResultsBean> resultsBeen, Context mContext) {
        this.resultsBeen = resultsBeen;
        this.mContext = mContext;
        mResultsBeen.addAll(resultsBeen);
        resultsBeen.clear();
    }
    public void addAll(List<LeiBieBean.ResultsBean> results){
        mResultsBeen.addAll(results);
        notifyDataSetChanged();
    }
    public  void clear(){
        mResultsBeen.clear();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.leibie_item_1, parent, false);
        LBItemViewHolder viewHolder = new LBItemViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LBItemViewHolder holder1 = (LBItemViewHolder) holder;
        String useType = mResultsBeen.get(position).getUseType();
        if (Integer.parseInt(useType)==1){
            holder1.zhuanti_item_1_name.setTextColor(Color.RED);
            holder1.zhuanti_item_1_name.setText(mResultsBeen.get(position).getName());
        }else{
            holder1.zhuanti_item_1_name.setTextColor(Color.BLACK);
            holder1.zhuanti_item_1_name.setText(mResultsBeen.get(position).getName());
        }
        holder1.zhuanti_item_1_jianjie.setText(mResultsBeen.get(position).getRemark());
        String images = mResultsBeen.get(position).getImages();
        if (images!=null) {
            Uri uri = Uri.parse(images);
            holder1.zhuanti_item_1_simimage.setImageURI(uri);
        }
    }

    @Override
    public int getItemCount() {
        return mResultsBeen!=null?mResultsBeen.size():0;
    }

    class LBItemViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView zhuanti_item_1_simimage;
        TextView zhuanti_item_1_name;
        TextView zhuanti_item_1_jianjie;

        public LBItemViewHolder(View itemView) {
            super(itemView);
            zhuanti_item_1_simimage = (SimpleDraweeView) itemView.findViewById(R.id.zhuanti_item_1_simimage);
            zhuanti_item_1_name = (TextView) itemView.findViewById(R.id.zhuanti_item_1_name);
            zhuanti_item_1_jianjie = (TextView) itemView.findViewById(R.id.zhuanti_item_1_jianjie);

        }
    }
}
