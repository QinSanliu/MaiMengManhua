package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunSubjectEntrity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016-12-15.
 */

public class MoreSubjectGridAdapter extends BaseAdapter {

    private Context context;
    private List<ZiXunSubjectEntrity.ResultsBean> datas;

    public MoreSubjectGridAdapter(Context context, List<ZiXunSubjectEntrity.ResultsBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyGridViewHolder myGridViewHolder;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_zixun_grid,viewGroup,false);
            myGridViewHolder=new MyGridViewHolder(view);
            view.setTag(myGridViewHolder);
        }else{
            myGridViewHolder= (MyGridViewHolder) view.getTag();
        }

        myGridViewHolder.content.setText(datas.get(i).getContent());
        String images = datas.get(i).getImages();
        Uri parse = Uri.parse(images);
        myGridViewHolder.images.setImageURI(parse);

        return view;
    }

    class MyGridViewHolder{

        private SimpleDraweeView images;
        private TextView content;

        public MyGridViewHolder(View view) {
            images= ((SimpleDraweeView) view.findViewById(R.id.item_zixun_grid_images));
            content= ((TextView) view.findViewById(R.id.item_zixun_grid_content));
        }
    }
}
