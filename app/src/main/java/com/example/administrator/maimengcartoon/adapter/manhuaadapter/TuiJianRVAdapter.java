package com.example.administrator.maimengcartoon.adapter.manhuaadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.example.administrator.maimengcartoon.bean.manhuabeans.TuiJianBean;
import com.example.administrator.maimengcartoon.fragment.manhuafaragment.ZXGXPagerFragment;
import com.example.administrator.maimengcartoon.manhuachongxieclass.HorizontalListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class TuiJianRVAdapter extends RecyclerView.Adapter {



    private View headerView;
    private Context mContext;
    private List<TuiJianBean.ResultsBean> resultsBeen;
    private List<TuiJianBean.ResultsBean.CartoonSetListBean> cartoonSetList;
    private FragmentManager fragmentManager;

    public void addHeadView(View headerView) {
        this.headerView = headerView;
    }

    public TuiJianRVAdapter(Context mContext, List<TuiJianBean.ResultsBean> resultsBeen, FragmentManager fragmentManager) {
        this.mContext = mContext;
        this.resultsBeen = resultsBeen;
        cartoonSetList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
       RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case 0:
                itemview = headerView;
                 viewHolder = new MyViewheadViewHolder(itemview);
                break;
            case 1://继续撸
                 itemview= LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_1,parent,false);
                 viewHolder= new Item1ViewHolder(itemview);
                Log.d("flag", "onCreateViewHolder: 继续撸的view加载");
                break;
            case 2://最近更新
                itemview= LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_2,parent,false);
                viewHolder= new ItemViewHolder5(itemview);
                break;
            case 3://小编推荐
                itemview = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_4,parent,false);
                viewHolder = new ItemviewHolder2(itemview);
                break;
            case 4://你的名字 item5
                itemview = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_5,parent,false);
                viewHolder = new ItemViewHolder10(itemview);
                Log.d("flag", "onCreateViewHolder: 你的名字case");
                break;
            case 5://每周手藏
                itemview = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_6,parent,false);
                viewHolder = new ItemViewHolder3(itemview);
                break;
            case 6://最新上架
                itemview = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_7,parent,false);
                viewHolder = new ItemViewholer6or9(itemview);
                break;
            case 7://猜你喜欢
                itemview = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item_7,parent,false);
                viewHolder = new ItemViewholer6or9(itemview);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int po) {
        int position  = po-1;
        if (holder instanceof MyViewheadViewHolder) {

        }else  if (holder instanceof Item1ViewHolder){//继续撸
                Item1ViewHolder holder1 = (Item1ViewHolder) holder;
                String iconurl = resultsBeen.get(position).getIcon();
                Log.d("flag", "onBindViewHolder: "+iconurl);
                if (iconurl!=null) {
                    Picasso.with(mContext).load(iconurl).into(holder1.item1_iamg);
                }
                holder1.item1_tv_jixu.setText(resultsBeen.get(position).getTitle());
                holder1.item1_tv_genxin.setText(resultsBeen.get(position).getDesc());
                initjixulu(position);//继续撸的横向方法

            }else if(holder instanceof ItemViewHolder5){//最新更新
                ItemViewHolder5 holder5 = (ItemViewHolder5) holder;
                String iconurl = resultsBeen.get(position).getIcon();
                if (iconurl!=null) {
                    Picasso.with(mContext).load(iconurl).into(holder5.tuijian_item_2_huojianiv);
                    Log.d("flag", "onBindViewHolder: 设置图片5");
                }
                holder5.tuijian_item_2_zuijintx.setText(resultsBeen.get(position).getTitle());
                holder5.tuijian_item_2_tiankentx.setText(resultsBeen.get(position).getDesc());
                Log.d("flag", "onBindViewHolder: 设置条目成功");
                initzuijingengxin(holder5.tuijian_item_2_viewpager,position);//最近更新添加viewpager

            }else if(holder instanceof ItemviewHolder2){//小编推荐
                ItemviewHolder2 holder2 = (ItemviewHolder2) holder;
                String iconurl = resultsBeen.get(position).getIcon();
                if (iconurl!=null) {
                    Picasso.with(mContext).load(iconurl).into(holder2.tuijian_item_4_xiangjiiv);
                    Log.d("flag", "onBindViewHolder: 设置图片5");
                }
                holder2.tuijian_item_4_xiaobiantx.setText(resultsBeen.get(position).getTitle());
                holder2.tuijian_item_4_laoshitx.setText(resultsBeen.get(position).getDesc());
                initxiabian(holder2.tuijian_item_4_listview,position);//小编推荐加载子recycle


            }else if(holder instanceof ItemViewHolder10){//你的名字
                ItemViewHolder10 holder10 = (ItemViewHolder10) holder;
                String images = resultsBeen.get(position).getImages();
                String images2 = resultsBeen.get(position).getImages2();
                if (images!=null||images2!=null) {
                    Picasso.with(mContext).load(images).into(holder10.tuijian_item_5_imageone);
                    Picasso.with(mContext).load(images2).into(holder10.tuijian_item_5_imagetow);
                    Log.d("flag", "onBindViewHolder: 设置图片5");
                }

            }else if(holder instanceof ItemViewHolder3){//每周收藏
                ItemViewHolder3 holder3 = (ItemViewHolder3) holder;
                String iconurl = resultsBeen.get(position).getIcon();
                if (iconurl!=null) {
                    Picasso.with(mContext).load(iconurl).into(holder3.tuijian_item_6_sctupianiv);
                    Log.d("flag", "onBindViewHolder: 设置图片5");
                }
                holder3.tuijian_item_6_shoucangtx.setText(resultsBeen.get(position).getTitle());
                holder3.tuijian_item_6_dajiatx.setText(resultsBeen.get(position).getDesc());
                initmeizhoushoucang(holder3.tuijian_item_6_listview,position);

            }else if(holder instanceof  ItemViewholer6or9){
                ItemViewholer6or9 or9 = (ItemViewholer6or9) holder;
                String iconurl = resultsBeen.get(position).getIcon();
                if (iconurl!=null) {
                    Picasso.with(mContext).load(iconurl).into(or9.tuijian_item_7_xiaonianiv);
                    Log.d("flag", "onBindViewHolder: 设置图片5");
                }
                or9.tuijian_item_7_cainitx.setText(resultsBeen.get(position).getTitle());
                or9.tuijian_item_7_xinshangtx.setText(resultsBeen.get(position).getDesc());
                initZUXSJandCNXH(or9.tuijian_item_7_gridview,position);

            }
    }



    @Override
    public int getItemCount() {
        return resultsBeen!=null?resultsBeen.size()+1:0;
    }

    //设置item多种布局的类型
    @Override
    public int getItemViewType(int position) {

//        String id = resultsBeen.get(position).getId();
//        int type = Integer.parseInt(id);
        return position;
    }
    //第一个类型继续撸
    class Item1ViewHolder extends RecyclerView.ViewHolder{
            ImageView item1_iamg;
            TextView item1_tv_jixu;
            TextView item1_tv_genxin;
            HorizontalListView tuijian_item_1_listview;
        public Item1ViewHolder(View itemView) {
            super(itemView);
            item1_iamg = (ImageView) itemView.findViewById(R.id.tuijian_item_1_shouiv);
            item1_tv_genxin= (TextView) itemView.findViewById(R.id.tuijian_item_1_genxintx);
            item1_tv_jixu = (TextView) itemView.findViewById(R.id.tuijian_item_1_jixulutx);
            tuijian_item_1_listview = (HorizontalListView) itemView.findViewById(R.id.tuijian_item_1_listview);

        }
    }
    //第二个类型最近更新
    class ItemViewHolder5 extends RecyclerView.ViewHolder{
            ImageView tuijian_item_2_huojianiv;
            TextView tuijian_item_2_zuijintx;
            TextView tuijian_item_2_tiankentx;
            ViewPager tuijian_item_2_viewpager;
        public ItemViewHolder5(View itemView) {
            super(itemView);
            tuijian_item_2_huojianiv = (ImageView) itemView.findViewById(R.id.tuijian_item_2_huojianiv);
            tuijian_item_2_zuijintx = (TextView) itemView.findViewById(R.id.tuijian_item_2_zuijintx);
            tuijian_item_2_tiankentx = (TextView) itemView.findViewById(R.id.tuijian_item_2_tiankentx);
            tuijian_item_2_viewpager = (ViewPager) itemView.findViewById(R.id.tuijian_item_2_viewpager);

        }
    }
    //第三个类型小编推荐
    class ItemviewHolder2 extends RecyclerView.ViewHolder{
            ImageView tuijian_item_4_xiangjiiv;
            TextView   tuijian_item_4_xiaobiantx;
            TextView   tuijian_item_4_laoshitx;
            RecyclerView tuijian_item_4_listview;


        public ItemviewHolder2(View itemView) {
            super(itemView);
            tuijian_item_4_xiangjiiv = (ImageView) itemView.findViewById(R.id.tuijian_item_4_xiangjiiv);
            tuijian_item_4_xiaobiantx = (TextView) itemView.findViewById(R.id.tuijian_item_4_xiaobiantx);
            tuijian_item_4_laoshitx = (TextView) itemView.findViewById(R.id.tuijian_item_4_laoshitx);
            tuijian_item_4_listview = (RecyclerView) itemView.findViewById(R.id.tuijian_item_4_listview);

        }
    }
    //第四种类型你的名字
    class  ItemViewHolder10 extends RecyclerView.ViewHolder{
            ImageView tuijian_item_5_imageone;
            ImageView tuijian_item_5_imagetow;
        public ItemViewHolder10(View itemView) {
            super(itemView);
            tuijian_item_5_imageone = (ImageView) itemView.findViewById(R.id.tuijian_item_5_imageone);
            tuijian_item_5_imagetow = (ImageView) itemView.findViewById(R.id.tuijian_item_5_imagetow);

        }
    }
    //第五种每周收藏
    class ItemViewHolder3 extends RecyclerView.ViewHolder{
        ImageView tuijian_item_6_sctupianiv;
        TextView tuijian_item_6_shoucangtx;
        TextView tuijian_item_6_dajiatx;
        RecyclerView tuijian_item_6_listview;

        public ItemViewHolder3(View itemView) {
            super(itemView);
            tuijian_item_6_sctupianiv = (ImageView) itemView.findViewById(R.id.tuijian_item_6_sctupianiv);
            tuijian_item_6_shoucangtx = (TextView) itemView.findViewById(R.id.tuijian_item_6_shoucangtx);
            tuijian_item_6_dajiatx = (TextView) itemView.findViewById(R.id.tuijian_item_6_dajiatx);
            tuijian_item_6_listview = (RecyclerView) itemView.findViewById(R.id.tuijian_item_6_listview);
        }
    }
    //第六种最新上架，第七种猜你喜欢
    class ItemViewholer6or9 extends RecyclerView.ViewHolder{
            ImageView tuijian_item_7_xiaonianiv;
            TextView tuijian_item_7_cainitx;
            TextView tuijian_item_7_xinshangtx;
            RecyclerView tuijian_item_7_gridview;
        public ItemViewholer6or9(View itemView) {
            super(itemView);
            tuijian_item_7_xiaonianiv = (ImageView) itemView.findViewById(R.id.tuijian_item_7_xiaonianiv);
            tuijian_item_7_cainitx = (TextView) itemView.findViewById(R.id.tuijian_item_7_cainitx);
            tuijian_item_7_xinshangtx = (TextView) itemView.findViewById(R.id.tuijian_item_7_xinshangtx);
            tuijian_item_7_gridview = (RecyclerView) itemView.findViewById(R.id.tuijian_item_7_gridview);
        }
    }

    //添加头布局的条目
    class MyViewheadViewHolder extends RecyclerView.ViewHolder{

        public MyViewheadViewHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * 七种item类型的子类型
     */

    //最新上架和猜你喜欢的加载数据界面
    private void initZUXSJandCNXH(RecyclerView tuijian_item_7_gridview, int position) {
        cartoonSetList =resultsBeen.get(position).getCartoonSetList();
        zuixinshangjiaandcannixihuanRecyclerAdapter adapter = new zuixinshangjiaandcannixihuanRecyclerAdapter(mContext,cartoonSetList);
        tuijian_item_7_gridview.setLayoutManager(new GridLayoutManager(mContext,3,LinearLayoutManager.VERTICAL,false));
        tuijian_item_7_gridview.setAdapter(adapter);


    }


    //每周收藏的多布局页面
    private void initmeizhoushoucang(RecyclerView tuijian_item_6_listview, int position) {
        cartoonSetList =resultsBeen.get(position).getCartoonSetList();
        Log.d("flag", "initxiabian: 小编推荐的"+cartoonSetList.size());
        meizhoushoucangRecyclerAdapter adapter = new meizhoushoucangRecyclerAdapter(mContext,cartoonSetList);
        tuijian_item_6_listview.setLayoutManager(new GridLayoutManager(mContext,3,LinearLayoutManager.HORIZONTAL,false));
        tuijian_item_6_listview.setAdapter(adapter);

    }
    //小编推荐加载子的recyclerview
    private void initxiabian(RecyclerView tuijian_item_4_listview, int position) {
        cartoonSetList =resultsBeen.get(position).getCartoonSetList();
        Log.d("flag", "initxiabian: 小编推荐的"+cartoonSetList.size());
        xiaobiantuijianAdapter adapter = new xiaobiantuijianAdapter(mContext,cartoonSetList);
        tuijian_item_4_listview.setLayoutManager(new GridLayoutManager(mContext,4, LinearLayoutManager.HORIZONTAL,false));
        tuijian_item_4_listview.setAdapter(adapter);

    }

    /**
     *
     * @param tuijian_item_2_viewpager ViewPager
     * @param position 当前一级集合 这里解除二级集合的坐标
     */

    //最近更新的viewpager
    private void initzuijingengxin(ViewPager tuijian_item_2_viewpager, int position) {

        //fragment viewpager适配器，二级数据
        Log.d("flag", "initzuijingengxin: 标签"+position);
        cartoonSetList = resultsBeen.get(position).getCartoonSetList();
        Log.d("flag", "initzuijingengxin:二级数据长度 "+cartoonSetList.size());
        int pagerIcon = cartoonSetList.size() / 6;
        List<Fragment> pageFragments = new ArrayList<>() ;
        ArrayList list = new ArrayList();
        //这个for循环不需要，只有一个fragment
        for (int i = 0; i < pagerIcon; i++) {
            ZXGXPagerFragment zxgxPagerFragment = new ZXGXPagerFragment();
            pageFragments.add(zxgxPagerFragment);
            Bundle bundle = new Bundle();
            list.add(cartoonSetList);
            bundle.putParcelableArrayList("cartoonSetList",list);
            bundle.putInt("myi",i);
            zxgxPagerFragment.setArguments(bundle);
        }
        ZXGXPagerFragmentAdapter zxgxPagerFragmentAdapter = new ZXGXPagerFragmentAdapter(fragmentManager,mContext,pageFragments);
        //两个ViewPager嵌套的滑动冲突
        tuijian_item_2_viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        tuijian_item_2_viewpager.setAdapter(zxgxPagerFragmentAdapter);
    }
    //继续撸的横向listview
    private void initjixulu(int position) {
        cartoonSetList = resultsBeen.get(position).getCartoonSetList();
    }



}
