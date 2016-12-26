package com.example.administrator.maimengcartoon.uri;

/**
 * Created by Administrator on 2016-12-12.
 */

public class AppInterface {
    public static final String ZI_XUN_TABS_URL="http://api.playsm.com/index.php?page=%d&r=messageTags%2Flist&size=60";
    public static final String ZI_XUN_LIST_URL="http://api.playsm.com/index.php?lastCount=37345&r=message%2Flist&lastID=0&size=100";
    public static final String ZI_XUN_SUBJECT_URL="http://api.playsm.com/index.php?order=priority&page=1&r=special%2Flist&size=29";
    public static final String ZI_XUN_IMAGE_URL="http://api.playsm.com/index.php?page=1&r=adImage%2Flist&customPosition=1&size=999";

    public static final String MEITU_SEARCH_URL = "http://api.playsm.com/index.php?searchLabel=%s&lastCount=40010&page=1&r=prettyImages%2Flist&size=10&";
    public static final String MEITU_URL_ONE = "http://api.playsm.com/index.php?searchLabel=";
    public static final String MEITU_URL_TWO = "&lastCount=40010&page=1&r=prettyImages%2Flist&size=10&";
    /**
     * 该内部静态类中是漫画的所有接口
     */
    public static class Manhua{
            //推荐
           public final static String TUI_JIAN = "http://api.playsm.com/index.php?categorys=&page=1&r=v6%2Frecommend%2FgetUserRecommendList&isNew=1&size=999&";
            //推荐的头布局
            public static final String TUI_JIAN_HAND="http://api.playsm.com/index.php?page=1&r=adImage%2Flist&customPosition=2&size=999";
            //专题
            public static final String ZHUAN_TI="http://api.playsm.com/index.php?page=";
            //page后面设置页数 初始值 为：1
            //专题拼接分页加载数据
            public static final String ZHUAN_TI_TOW="&r=cartoonBillBoard%2Flist&size=10&";
        //类别分页加载数据，需拼接
            public static final String LEI_BIE_ONE="http://api.playsm.com/index.php?page=";
        //page后面设置页数 初始值 为：1
            public static final String LEI_BIE_TOW="&r=cartoonCategory%2Flist&size=10&";

        }
}
