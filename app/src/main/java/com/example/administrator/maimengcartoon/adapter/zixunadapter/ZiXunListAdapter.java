package com.example.administrator.maimengcartoon.adapter.zixunadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.zixunbean.ZiXunListEntrity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016-12-13.
 */

public class ZiXunListAdapter extends BaseAdapter {
    private Context context;
    private List<ZiXunListEntrity.ResultsBean> datas;

    public ZiXunListAdapter(Context context, List<ZiXunListEntrity.ResultsBean> datas) {
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
        ViewHolder viewHolder;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_zi_xun_list,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(datas.get(i).getTitle());
        viewHolder.createTimeValue.setText(datas.get(i).getCreateTimeValue());

        String images = datas.get(i).getImages();

        Picasso .with(context)
                .load(images)
                .placeholder(R.mipmap.jiazaitu)
                .error(R.mipmap.jiazaitu)
                .into(viewHolder.imageView);
        return view;
    }

    class ViewHolder{
        private ImageView imageView;
        private TextView title,createTimeValue;

        public ViewHolder(View view) {
            imageView= ((ImageView) view.findViewById(R.id.item_zi_xun_list_image));
            title= ((TextView) view.findViewById(R.id.item_zi_xun_list_title));
            createTimeValue=((TextView) view.findViewById(R.id.item_zi_xun_list_createTimeValue));
        }
    }
}
