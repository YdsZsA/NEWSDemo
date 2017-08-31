package com.example.bwie.newsdemo.utils;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.umeng.socialize.PlatformConfig;

import org.xutils.x;



public class MyApp extends Application {
    @Override
    public void onCreate() {
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=58155541");
        super.onCreate();
        PlatformConfig.setQQZone("1106036236", "mjFCi0oxXZKZEWJs");
        x.Ext.init(this);

    }
}
