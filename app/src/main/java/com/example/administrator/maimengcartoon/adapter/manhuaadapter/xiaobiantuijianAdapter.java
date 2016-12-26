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

public class xiaobiantuijianAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen;

    public xiaobiantuijianAdapter(Context mContext, List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetListBeen) {
        this.mContext = mContext;
        this.cartoonSetListBeen = cartoonSetListBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        Log.d("flag", "onCreateViewHolder: 类型的值"+viewType);
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(mContext).inflate(R.layout.xiaobiantuijian_item1,parent,false);
                viewHolder = new xiaoItemViewHolder1(view);
                break;
            case 1:
                Log.d("flag", "onCreateViewHolder: 第二个界面有没有数据");
                view = LayoutInflater.from(mContext).inflate(R.layout.xiaobiantuijian_item2,parent,false);
                viewHolder = new xiaoItemViewHolder2(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("flag", "onBindViewHolder: 二级子页面的页数"+position);
        if (holder instanceof xiaoItemViewHolder1){
            xiaoItemViewHolder1 holder1 = (xiaoItemViewHolder1) holder;
            String images = cartoonSetListBeen.get(position).getImages();
            if (images!=null) {
                Uri uri = Uri.parse(images);
                holder1.tuijian_item_4_simiamgview_1.setImageURI(uri);
            }
            holder1.tuijian_item_4_name_1.setText(cartoonSetListBeen.get(position).getName());
            holder1.tuijian_item_4_zuozhe_1.setText("作者： "+cartoonSetListBeen.get(position).getAuthor());
            holder1.tuijian_item_4_leixing.setText("类型： "+cartoonSetListBeen.get(position).getCategoryLabel());
            holder1.tuijian_item_4_jianjie.setText(cartoonSetListBeen.get(position).getIntroduction());

        }else if(holder instanceof xiaoItemViewHolder2){
            xiaoItemViewHolder2 holder2 = (xiaoItemViewHolder2) holder;
            String images = cartoonSetListBeen.get(position).getImages();
            Log.d("flag", "onBindViewHolder: 第二个图片"+images);
            if (images!=null) {
                Uri uri = Uri.parse(images);
                holder2.tuijian_item_4_simiamgview_2.setImageURI(uri);
            }
            holder2.tuijian_item_4_name_2.setText(cartoonSetListBeen.get(position).getName());
            holder2.tuijian_item_4_zuozhe_2.setText("作者： "+cartoonSetListBeen.get(position).getAuthor());
            holder2.tuijian_item_4_leixing_2.setText("类型："+cartoonSetListBeen.get(position).getCategoryLabel());
        }


    }

    @Override
    public int getItemCount() {
        return cartoonSetListBeen.size();
    }

    class xiaoItemViewHolder1 extends RecyclerView.ViewHolder{
        SimpleDraweeView tuijian_item_4_simiamgview_1;
        TextView tuijian_item_4_name_1;
        TextView tuijian_item_4_zuozhe_1;
        TextView tuijian_item_4_leixing;
        TextView tuijian_item_4_jianjie;

        public xiaoItemViewHolder1(View itemView) {
            super(itemView);
            tuijian_item_4_simiamgview_1 = (SimpleDraweeView) itemView.findViewById(R.id.tuijian_item_4_simiamgview_1);
            tuijian_item_4_name_1 = (TextView) itemView.findViewById(R.id.tuijian_item_4_name_1);
            tuijian_item_4_zuozhe_1 = (TextView) itemView.findViewById(R.id.tuijian_item_4_zuozhe_1);
            tuijian_item_4_leixing = (TextView) itemView.findViewById(R.id.tuijian_item_4_leixing);
            tuijian_item_4_jianjie = (TextView) itemView.findViewById(R.id.tuijian_item_4_jianjie);

        }
    }
      class xiaoItemViewHolder2 extends RecyclerView.ViewHolder{
          SimpleDraweeView tuijian_item_4_simiamgview_2;
          TextView tuijian_item_4_name_2;
          TextView tuijian_item_4_zuozhe_2;
          TextView tuijian_item_4_leixing_2;

        public xiaoItemViewHolder2(View itemView) {
            super(itemView);
            tuijian_item_4_simiamgview_2 = (SimpleDraweeView) itemView.findViewById(R.id.tuijian_item_4_simiamgview_2);
            tuijian_item_4_name_2 = (TextView) itemView.findViewById(R.id.tuijian_item_4_name_2);
            tuijian_item_4_zuozhe_2 = (TextView) itemView.findViewById(R.id.tuijian_item_4_zuozhe_2);
            tuijian_item_4_leixing_2 = (TextView) itemView.findViewById(R.id.tuijian_item_4_leixing_2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }
}
