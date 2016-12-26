package com.example.administrator.maimengcartoon.ui.zixunui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.maimengcartoon.R;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class ZiXunWebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private String shareUrl;
    private ImageView fanhui;
    private TextView name;
    private ImageView share;
    private String title;
    private ImageView biaoqian;
    private boolean falg=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_xun_web_view);

        initView();

        Intent intent=getIntent();
        shareUrl = intent.getStringExtra("shareUrl");
        title = intent.getStringExtra("title");

        //设置webView在本应用加载数据，不进行跳转
        webView.setWebViewClient(new WebViewClient());

        //允许js交互
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(shareUrl);

        name.setText(title);

        fanhui.setOnClickListener(this);
        share.setOnClickListener(this);
        biaoqian.setOnClickListener(this);
    }

    private void initView() {
        webView = ((WebView) findViewById(R.id.activity_zixun_webview));
        fanhui = ((ImageView) findViewById(R.id.activity_zixun_webview_fanhui));
        name = ((TextView) findViewById(R.id.activity_zixun_webview_name));
        share = ((ImageView) findViewById(R.id.activity_zixun_webview_share));
        biaoqian = ((ImageView) findViewById(R.id.activity_zixun_webview_biaoqian));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_zixun_webview_fanhui://返回
                finish();
                break;
            case R.id.activity_zixun_webview_share://分享
                showShare();
                break;
            case R.id.activity_zixun_webview_biaoqian:
                if (falg){
                    biaoqian.setImageResource(R.mipmap.jianpan);
                    falg=false;
                }else{
                    biaoqian.setImageResource(R.mipmap.biaoqing1080);
                    falg=true;
                }
                break;

        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
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
        oks.show(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShareSDK.stopSDK();
    }
}
