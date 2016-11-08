package com.warren.meng.topnews.util;

/**
 * Created by meng on 2016/11/8.
 */

public class Constant {

    public static final String BASEURL
            ="http://v.juhe.cn/toutiao/";
    public static final String KEY
            ="efb9eaf6f172e23305ed9d302ff15ce9";

    public static final String[] types
            = new String[]{"top","shehui","yule","tiyu","shishang"};
    public static final String[] typesCN
            = new String[]{"头条","社会","娱乐","体育","时尚"};

    String s =  "类型,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐)," +
           "tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)";
    String example = "http://v.juhe.cn/toutiao/index?type=top&key=efb9eaf6f172e23305ed9d302ff15ce9";


}
