package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunListEntrity;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunTabEntrity;
import com.example.administrator.maimengcartoon.ui.zixunui.AllTabsActivity;
import com.example.administrator.maimengcartoon.ui.zixunui.ZiXunWebViewActivity;
import com.example.administrator.maimengcartoon.widget.MyListView;

import java.util.List;

/**
 * Created by Administrator on 2016-12-12.
 */

public class ZiXunRVAdapter extends RecyclerView.Adapter {
    private List<ZiXunListEntrity.ResultsBean> datas;
    private List<ZiXunTabEntrity.ResultsBean> tabDatas;
    private List<ZiXunTabEntrity.ResultsBean> data;
    private Context context;
    private View headerView;

    public static final int HEAD_TYPE=0;
    public static final int BODY_TYPE1=1;
    public static final int BODY_TYPE2=2;


    public ZiXunRVAdapter(List<ZiXunListEntrity.ResultsBean> datas, List<ZiXunTabEntrity.ResultsBean> tabDatas, List<ZiXunTabEntrity.ResultsBean> data, Context context) {
        this.datas = datas;
        this.tabDatas=tabDatas;
        this.data=data;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEAD_TYPE;
        }else if (position==1){
            return BODY_TYPE1;
        }
        return BODY_TYPE2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        switch (viewType) {
            case HEAD_TYPE:
                itemView=headerView;
                MyViewHolder2 myViewHolder = new MyViewHolder2(itemView);
                return myViewHolder;

            case BODY_TYPE1:
                itemView= LayoutInflater.from(context).inflate(R.layout.item_zi_xun_tab,parent,false);
                MyViewHolder1 myViewHolder1 = new MyViewHolder1(itemView);
                return myViewHolder1;
            case BODY_TYPE2:
                itemView=LayoutInflater.from(context).inflate(R.layout.item_zi_xun_listview,parent,false);
                MyViewHolder2 myViewHolder2 = new MyViewHolder2(itemView);
                return myViewHolder2;
        }
        return null;
    }

    private boolean falg=true;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEAD_TYPE:
                break;
            case BODY_TYPE1:
                final MyViewHolder1 holder1 = (MyViewHolder1) holder;

                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false);
                holder1.recyclerView.setLayoutManager(gridLayoutManager);

                ZiXunTabAdapter ziXunTabAdapter = new ZiXunTabAdapter(data, context);
                holder1.recyclerView.setAdapter(ziXunTabAdapter);

                holder1.moreTabs.setVisibility(View.GONE);

                holder1.tabs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       if (falg){
                           holder1.tabs.setImageResource(R.mipmap.image_tab_trianglechecked);
                           ZiXunTabAdapter ziXunTabAdapter = new ZiXunTabAdapter(tabDatas, context);
                           holder1.recyclerView.setAdapter(ziXunTabAdapter);
                           holder1.moreTabs.setVisibility(View.VISIBLE);
                           falg=false;
                       }else{
                           holder1.tabs.setImageResource(R.mipmap.image_tab_triangle);
                           ZiXunTabAdapter ziXunTabAdapter = new ZiXunTabAdapter(data, context);
                           holder1.recyclerView.setAdapter(ziXunTabAdapter);
                           holder1.moreTabs.setVisibility(View.GONE);
                           falg=true;
                       }
                    }
                });

                holder1.moreTabs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context, AllTabsActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case BODY_TYPE2:
                MyViewHolder2 holder2 = (MyViewHolder2) holder;
                ZiXunListAdapter ziXunListAdapter = new ZiXunListAdapter(context, datas);
                holder2.listView.setAdapter(ziXunListAdapter);

                holder2.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String shareUrl = datas.get(i).getShareUrl();
                        String title = datas.get(i).getTitle();
                        Intent intent=new Intent(context, ZiXunWebViewActivity.class);
                        intent.putExtra("shareUrl",shareUrl);
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public void addHeaderView(View headerView){
        this.headerView=headerView;
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{

        private ImageView tabs;
        private RecyclerView recyclerView;
        private TextView moreTabs;

        public MyViewHolder1(View itemView) {
            super(itemView);
            tabs= ((ImageView) itemView.findViewById(R.id.item_zi_xun_tab_tabs));
            recyclerView= ((RecyclerView) itemView.findViewById(R.id.item_zi_xun_tab_recyclerView));
            moreTabs= ((TextView) itemView.findViewById(R.id.item_zi_xun_moretab));

        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder{

        private MyListView listView;

        public MyViewHolder2(View itemView) {
            super(itemView);
            listView= ((MyListView) itemView.findViewById(R.id.item_zi_xun_listview));
        }
    }
}