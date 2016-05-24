package com.yoyo.yopassword.common.config;

/**
 * 项目名称：YoPassword
 * 类描述：
 * 创建人：yoyo
 * 创建时间：2016/5/23 15:54
 * 修改人：yoyo
 * 修改时间：2016/5/23 15:54
 * 修改备注：
 */
public class AppConfig {
    public final static boolean isDebug=true;
    public final static String logTag="YoPassword";
    public final static String KEY_SCOPE="all"; // 获取信息的范围参数
    public final static String KEY_APP_ID="1105311351";
    public final static int minPageSize = 18;//判断是否显示加载更多
    //上下拉刷新延迟时间
    public final static long RefreshViewTime = 500;//毫秒
}
