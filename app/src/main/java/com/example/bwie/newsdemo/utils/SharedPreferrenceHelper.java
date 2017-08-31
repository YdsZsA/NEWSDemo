package com.example.bwie.newsdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * data 2017/8/13.
 * author:赵鑫
 * function:
 */

public class SharedPreferrenceHelper {
    //theme(主题)
    private static final String THEME = "theme";
    //更改主题,传入两个参数,一个上下文,一个theme(主题)
    public static void setTheme(Context context, String theme) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("theme", Context.MODE_PRIVATE);
        //将theme(主题)存入SharedPreferences
        sharedPreferences.edit().putString(THEME, theme).apply();
    }
    //取出主题
    public static String getTheme(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("theme", Context.MODE_PRIVATE);
        //取出theme(主题)
        return sharedPreferences.getString(THEME, "1");
    }

}
