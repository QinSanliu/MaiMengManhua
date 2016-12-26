package com.example.administrator.maimengcartoon.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MeituDetailActivity extends AppCompatActivity {

    private ImageView sourceImage;
    private SimpleDraweeView meitu_detail_sdv_touxiang;
    private TextView meitu_detail_username,meitu_detail_showTime,meitu_detail_praiseCount,meitu_detail_label;
    private FloatingActionButton fanhui;
    private TextView btn_comment,btn_download,btn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meitu_detail);

        initView();

        String imgPath = getIntent().getStringExtra("imgPath");
        String 头像 = getIntent().getStringExtra("头像");
        String 用户名 = getIntent().getStringExtra("用户名");
        String 发布时间 = getIntent().getStringExtra("发布时间");
        String 点赞数 = getIntent().getStringExtra("点赞数");
        String 所属标签 = getIntent().getStringExtra("所属标签");



        Picasso.with(this).load(imgPath).error(R.mipmap.image_load_bg).into(sourceImage);
        AbstractDraweeController draweeController = Fresco.newDraweeControllerBuilder().setUri(头像).build();
        meitu_detail_sdv_touxiang.setController(draweeController);
        meitu_detail_username.setText(用户名);
        meitu_detail_showTime.setText(发布时间);
        meitu_detail_praiseCount.setText(点赞数);
        meitu_detail_label.setText(所属标签);

        settingBtn();
//        fanhui = (FloatingActionButton) findViewById(R.id.meitu_detail_fanhui);
//
//        fanhui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MeituDetailActivity.this, "返回", Toast.LENGTH_SHORT).show();
//                onBackPressed();
//            }
//        });

    }

    private void settingBtn() {
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareSDK.initSDK(MeituDetailActivity.this);
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

                // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("标题");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("ShareSDK");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");

                // 启动分享GUI
                oks.show(MeituDetailActivity.this);
            }
        });
    }

    private void initView() {
        sourceImage = (ImageView) findViewById(R.id.meitu_detail_img);
        meitu_detail_sdv_touxiang = ((SimpleDraweeView) findViewById(R.id.meitu_detail_sdv_touxaing));
        meitu_detail_username = (TextView) findViewById(R.id.meitu_detail_username);
        meitu_detail_showTime = (TextView) findViewById(R.id.showTime);
        meitu_detail_praiseCount = (TextView) findViewById(R.id.meitu_praiseCount);
        meitu_detail_label = (TextView) findViewById(R.id.meitu_detail_label);

        btn_share = (TextView) findViewById(R.id.btn_share);
        btn_download = (TextView) findViewById(R.id.btn_download);
        btn_comment = (TextView) findViewById(R.id.btn_comment);


    }
}
