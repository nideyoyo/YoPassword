package com.yoyo.yopassword.common.tool;

import android.text.TextUtils;

/**
 * Created by nidey on 2016/5/30.
 */
public class AppSingletonTools {
    private AppSingletonTools() {}
    private static AppSingletonTools single=null;
    //静态工厂方法
    public static synchronized AppSingletonTools getInstance() {
        if (single == null) {
            single = new AppSingletonTools();
        }
        return single;
    }
/*
    private static MainActivity instanceMainActivity;

    public void initMainActivity(MainActivity instanceMainActivity){
        this.instanceMainActivity=instanceMainActivity;
    }

    public void destroyMainActivity(){
        this.instanceMainActivity=null;
    }

    public static void destroy(){
        instanceMainActivity=null;
        single=null;
    }

    public void refreshGrouping(){
        if(instanceMainActivity!=null){
            instanceMainActivity.mSectionsPagerAdapter.refreshData();
        }
    }

    public void refreshPassword(){
        if(instanceMainActivity!=null){
            instanceMainActivity.mSectionsPagerAdapter.refreshData();
        }
    }
    public void refreshFragmentOneItem(){
        if(instanceMainActivity!=null){
            instanceMainActivity.refreshFragmentOneItem();
        }
    }


    public void refreshFragmentItem(long groupingId){
        if(instanceMainActivity!=null){
            instanceMainActivity.refreshFragmentItem(groupingId);
        }
    }*/

    public static String getRemarksText(String remarks){
        if(TextUtils.isEmpty(remarks)){
            return "无";
        }
        return remarks;
    }
}
