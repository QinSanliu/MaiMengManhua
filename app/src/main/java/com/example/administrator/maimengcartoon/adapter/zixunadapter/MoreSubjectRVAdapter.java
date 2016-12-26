package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunSubjectEntrity;
import com.example.administrator.maimengcartoon.widget.MyGridView;

import java.util.List;

/**
 * Created by Administrator on 2016-12-15.
 */

public class MoreSubjectRVAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ZiXunSubjectEntrity.ResultsBean> listDatas;
    private List<ZiXunSubjectEntrity.ResultsBean> gridDatas;

    private static final int BODY_TYPE1=0;
    private static final int BODY_TYPE2=1;

    public MoreSubjectRVAdapter(Context context,List<ZiXunSubjectEntrity.ResultsBean> listDatas,List<ZiXunSubjectEntrity.ResultsBean> gridDatas ) {
        this.context = context;
        this.listDatas = listDatas;
        this.gridDatas=gridDatas;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return BODY_TYPE1;
        }
        return BODY_TYPE2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        switch (viewType) {
            case BODY_TYPE1:
                itemView= LayoutInflater.from(context).inflate(R.layout.item_subject_list,parent,false);
                MySubjectViewHolder1 mySubjectViewHolder1 = new MySubjectViewHolder1(itemView);
                return mySubjectViewHolder1;
            case BODY_TYPE2:
                itemView=LayoutInflater.from(context).inflate(R.layout.item_subject_grid,parent,false);
                MySubjectViewHolder2 mySubjectViewHolder2 = new MySubjectViewHolder2(itemView);
                return mySubjectViewHolder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BODY_TYPE1:
                MySubjectViewHolder1 holder1 = (MySubjectViewHolder1) holder;

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                holder1.listRecyclerView.setLayoutManager(linearLayoutManager);

                MoreSubjectListAdapter moreSubjectListAdapter = new MoreSubjectListAdapter(context, listDatas);
                holder1.listRecyclerView.setAdapter(moreSubjectListAdapter);
                break;
            case BODY_TYPE2:
                MySubjectViewHolder2 holder2 = (MySubjectViewHolder2) holder;

                MoreSubjectGridAdapter moreSubjectGridAdapter = new MoreSubjectGridAdapter(context, gridDatas);
                holder2.myGridView.setAdapter(moreSubjectGridAdapter);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MySubjectViewHolder1 extends RecyclerView.ViewHolder{

        private RecyclerView listRecyclerView;

        public MySubjectViewHolder1(View itemView) {
            super(itemView);

            listRecyclerView= ((RecyclerView) itemView.findViewById(R.id.item_subject_list_recyclerView));
        }
    }

    class MySubjectViewHolder2 extends RecyclerView.ViewHolder{

        private MyGridView myGridView;

        public MySubjectViewHolder2(View itemView) {
            super(itemView);
            myGridView= ((MyGridView) itemView.findViewById(R.id.item_subject_grid_myGridView));
        }
    }
}
