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
import com.example.administrator.maimengcartoon.bean.manhuabeans.ZhuanTiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public class ZhuanTiRVAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ZhuanTiBean.ResultsBean> resultsBeenone;
    private List<ZhuanTiBean.ResultsBean> resultsBeen =new ArrayList<>();

    public ZhuanTiRVAdapter(Context mContext, List<ZhuanTiBean.ResultsBean> resultsBeenone) {
        this.mContext = mContext;
        this.resultsBeenone = resultsBeenone;
        resultsBeen.addAll(resultsBeenone);
        resultsBeenone.clear();


    }

    public void addAll(List<ZhuanTiBean.ResultsBean> results){
       resultsBeen.addAll(results);
        notifyDataSetChanged();
    }
    public void clear(){
        resultsBeen.clear();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                    itemview = LayoutInflater.from(mContext).inflate(R.layout.zhuanti_item_1,parent,false);
                    viewHolder = new ZHItemViewHolderone(itemview);
                break;
            case 1:
                itemview = LayoutInflater.from(mContext).inflate(R.layout.zhuanti_item_2,parent,false);
                viewHolder = new ZHItemViewHoldertow(itemview);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ZHItemViewHolderone) {
            ZHItemViewHolderone holder1 = (ZHItemViewHolderone) holder;
            String images = resultsBeen.get(position).getImages();
            String priority = resultsBeen.get(position).getPriority();
            ImageView iamgeview = null;
//            switch (Integer.parseInt(priority)){
//                case 1:
//                    iamgeview = holder1.zhunti_item_1_shoucang;
//                    break;
//                case 2:
//                    iamgeview = holder1.zhunti_item_1_dianji;
//                    break;
//                case 3:
//                    iamgeview = holder1.zhunti_item_1_renqi;
//                    break;
//                case 4:
//                    iamgeview = holder1.zhunti_item_1_cuigeng;
//                    break;
//            }
            iamgeview = holder1.zhunti_item_1_shoucang;
            if (images!=null) {
                Uri uri = Uri.parse(images);
                iamgeview.setImageURI(uri);
            }
//            if (mOnItemClickListener!=null) {
//                iamgeview.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mOnItemClickListener.OnItemClick(position);
//                    }
//                });
//            }
//            if (images!=null) {
//                Uri uri = Uri.parse(images);
//                iamgeview.setImageURI(uri);
//            }
        }else if(holder instanceof ZHItemViewHoldertow){
            ZHItemViewHoldertow holder2 = (ZHItemViewHoldertow) holder;
            String images = resultsBeen.get(position).getImages();
            if (images!=null) {
                Uri uri = Uri.parse(images);
                holder2.zhuanti_item_2_simImage.setImageURI(uri);
            }
            holder2.zhunti_item_2_imagName.setText(resultsBeen.get(position).getName());
            holder2.zhuanti_item_2_jieshao.setText(resultsBeen.get(position).getIntroduction());

        }

    }

    @Override
    public int getItemCount() {
        return resultsBeen!=null?resultsBeen.size():0;
    }

    @Override
    public int getItemViewType(int position) {
        String priority = resultsBeen.get(position).getPriority();
        if (Integer.parseInt(priority)<=4){
            return 0;
        }else {
            return 1;
        }
    }

    class ZHItemViewHolderone extends RecyclerView.ViewHolder{
        SimpleDraweeView zhunti_item_1_shoucang;
//        SimpleDraweeView zhunti_item_1_dianji;
//        SimpleDraweeView zhunti_item_1_renqi;
//        SimpleDraweeView zhunti_item_1_cuigeng;

        public ZHItemViewHolderone(View itemView) {
            super(itemView);
            zhunti_item_1_shoucang = (SimpleDraweeView) itemView.findViewById(R.id.zhunti_item_1_shoucang);
//            zhunti_item_1_dianji = (SimpleDraweeView) itemView.findViewById(R.id.zhunti_item_1_dianji);
//            zhunti_item_1_renqi = (SimpleDraweeView) itemView.findViewById(R.id.zhunti_item_1_renqi);
//            zhunti_item_1_cuigeng = (SimpleDraweeView) itemView.findViewById(R.id.zhunti_item_1_cuigeng);
        }
    }

    class ZHItemViewHoldertow extends RecyclerView.ViewHolder{
        SimpleDraweeView zhuanti_item_2_simImage;
        TextView zhunti_item_2_imagName;
        TextView zhuanti_item_2_jieshao;
        public ZHItemViewHoldertow(View itemView) {
            super(itemView);
            zhuanti_item_2_simImage = (SimpleDraweeView) itemView.findViewById(R.id.zhuanti_item_2_simImage);
            zhunti_item_2_imagName = (TextView) itemView.findViewById(R.id.zhunti_item_2_imagName);
            zhuanti_item_2_jieshao = (TextView) itemView.findViewById(R.id.zhuanti_item_2_jieshao);
        }
    }

}
