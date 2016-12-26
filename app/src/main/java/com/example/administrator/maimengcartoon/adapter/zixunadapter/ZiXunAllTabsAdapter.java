package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunTabEntrity;

import java.util.List;

/**
 * Created by Administrator on 2016-12-13.
 */

public class ZiXunAllTabsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ZiXunTabEntrity.ResultsBean> datas;

    public ZiXunAllTabsAdapter(Context context, List<ZiXunTabEntrity.ResultsBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.item_zi_xun_alltab,parent,false);
        MyAllTabViewHolder myAllTabViewHolder = new MyAllTabViewHolder(itemView);
        return myAllTabViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyAllTabViewHolder holder1 = (MyAllTabViewHolder) holder;

        holder1.name.setText(datas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyAllTabViewHolder extends RecyclerView.ViewHolder{

        private TextView name;

        public MyAllTabViewHolder(View itemView) {
            super(itemView);
            name= ((TextView) itemView.findViewById(R.id.item_zi_xun_alltab_name));
        }
    }
}
