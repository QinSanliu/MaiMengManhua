package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunSubjectEntrity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016-12-15.
 */

public class MoreSubjectListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ZiXunSubjectEntrity.ResultsBean> datas;

    public MoreSubjectListAdapter(Context context, List<ZiXunSubjectEntrity.ResultsBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.item_zixun_list,parent,false);
        MyListViewHolder myListViewHolder = new MyListViewHolder(itemView);
        return myListViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyListViewHolder holder1 = (MyListViewHolder) holder;
        holder1.name.setText(datas.get(position).getName());
        holder1.content.setText(datas.get(position).getContent());
        holder1.messageCount.setText("共"+datas.get(position).getMessageCount()+"篇");

        String thumbnail = datas.get(position).getThumbnail();
        Uri parse = Uri.parse(thumbnail);
        holder1.thumbnail.setImageURI(parse);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView thumbnail;
        private TextView name,content,messageCount;

        public MyListViewHolder(View itemView) {
            super(itemView);
            thumbnail= ((SimpleDraweeView) itemView.findViewById(R.id.item_zixun_list_thumbnail));
            name= ((TextView) itemView.findViewById(R.id.item_zixun_list_name));
            content= ((TextView) itemView.findViewById(R.id.item_zixun_list_content));
            messageCount= ((TextView) itemView.findViewById(R.id.item_zixun_list_messageCount));
        }
    }
}
