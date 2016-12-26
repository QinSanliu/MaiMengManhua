package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunTabEntrity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016-12-13.
 */

public class ZiXunTabAdapter extends RecyclerView.Adapter {
    private List<ZiXunTabEntrity.ResultsBean> tabDatas;
    private Context context;

    public ZiXunTabAdapter(List<ZiXunTabEntrity.ResultsBean> tabDatas, Context context) {
        this.tabDatas = tabDatas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.item_zi_xun_grid,parent,false);
        MyTabViewHolder myTabViewHolder = new MyTabViewHolder(itemView);
        return myTabViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyTabViewHolder holder1 = (MyTabViewHolder) holder;

        holder1.name.setText(tabDatas.get(position).getName());
        String images = tabDatas.get(position).getImages();
        Picasso .with(context)
                .load(images)
                .placeholder(R.mipmap.jiazaitu)
                .error(R.mipmap.jiazaitu)
                .into(holder1.images);
    }

    @Override
    public int getItemCount() {
        return tabDatas.size();
    }

    class MyTabViewHolder extends RecyclerView.ViewHolder{

        private ImageView images;
        private TextView name;

        public MyTabViewHolder(View itemView) {
            super(itemView);
            images= ((ImageView) itemView.findViewById(R.id.item_zi_xun_grid_images));
            name= ((TextView) itemView.findViewById(R.id.item_zi_xun_grid_name));
        }
    }
}
