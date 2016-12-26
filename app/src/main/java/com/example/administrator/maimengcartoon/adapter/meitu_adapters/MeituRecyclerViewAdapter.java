package com.example.administrator.maimengcartoon.adapter.meitu_adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.meitu.MeituEntity;
import com.example.administrator.maimengcartoon.ui.MeituDetailActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by qinsa on 2016/12/12.
 */

public class MeituRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<MeituEntity.ResultsBean> meituData;
    private Context meituContext;

    public MeituRecyclerViewAdapter(List<MeituEntity.ResultsBean> meituData, Context meituContext) {
        this.meituData = meituData;
        this.meituContext = meituContext;
    }
    /***  Item点击事件*/
    private OnItemClickListener mOnItemClickListener;

    @Override
    public void onClick(View view) {
//        Integer position = (Integer) view.getTag();
        switch (view.getId()){
            case R.id.meitu_item_layout:
                mOnItemClickListener.itemClick(view);

                break;
            case R.id.meitu_item_praiseCount:
                mOnItemClickListener.itemClick(view);
                break;
        }
    }

    public interface OnItemClickListener{
        void itemClick(View view);
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(meituContext)
                .inflate(R.layout.meitu_recyclerview_item,parent,false);
        MyViewHolder holder = new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.meitu_item_username.setText(meituData.get(position).getUserIDInfo().getName());
        myViewHolder.meitu_item_username.setTag(position);
        myViewHolder.meitu_item_praiseCount.setText(meituData.get(position).getPraiseCount());
        myViewHolder.meitu_item_praiseCount.setTag(position);

        String imgPath = meituData.get(position).getImages();
        String touxiangPath = meituData.get(position).getUserIDInfo().getImages();

        Picasso.with(meituContext)
                .load(imgPath)
                .placeholder(R.mipmap.jiazaitu)
                .error(R.mipmap.image_load_bg)
                .into(myViewHolder.meitu_item_img);

        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setUri(touxiangPath).build();
        myViewHolder.meitu_item_touxiang.setController(controller);

        myViewHolder.meitu_item_praiseCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(meituContext, "点赞+1", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sourceImages = meituData.get(position).getSourceImages();
                Intent intent = new Intent(meituContext, MeituDetailActivity.class);
                intent.putExtra("imgPath",sourceImages);
                intent.putExtra("头像",meituData.get(position).getUserIDInfo().getImages());
                intent.putExtra("用户名",meituData.get(position).getUserIDInfo().getName());
                intent.putExtra("发布时间",meituData.get(position).getShowTime());
                intent.putExtra("点赞数",meituData.get(position).getPraiseCount());
                intent.putExtra("所属标签",meituData.get(position).getLabel());

                meituContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meituData!=null?meituData.size():0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView meitu_item_img;
        public SimpleDraweeView meitu_item_touxiang;
        public TextView meitu_item_username,meitu_item_praiseCount;
        public View itemLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            meitu_item_img = (ImageView) itemView.findViewById(R.id.meitu_item_img);

            meitu_item_touxiang = (SimpleDraweeView) itemView.findViewById(R.id.meitu_item_touxiang);
            meitu_item_praiseCount = (TextView) itemView.findViewById(R.id.meitu_item_praiseCount);
            meitu_item_username = (TextView) itemView.findViewById(R.id.meitu_item_username);

            itemLayout = itemView.findViewById(R.id.meitu_item_layout);
        }
    }
}
