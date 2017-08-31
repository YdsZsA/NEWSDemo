package com.example.bwie.newsdemo.utils;

import android.content.Context;

import com.example.bwie.newsdemo.R;


/**
 * data 2017/8/13.
 * author:赵鑫
 * function:
 */

public class Utils {
    //获取主题,根据给定的值来判断是夜间还是黑夜
    public  static int getAppTheme(Context context){
        //将theme取出
        String value = SharedPreferrenceHelper.getTheme(context);
        //判断theme转为int类型的值
        switch (Integer.valueOf(value)){
            case 1:
                //白天的主题
                return R.style.AppTheme;
            case 2:
                //夜间的主题
                return R.style.AppThemeDark;
            default:
                //默认白天
                return R.style.AppTheme;
        }
}
    //更改主题,当为白天时将给定的值改成黑夜,为黑夜反之
    public static void switchAppTheme(Context context){
        String value = SharedPreferrenceHelper.getTheme(context);
        switch (Integer.valueOf(value)){
            case 1:
                //当为白天时调用这个方法变成黑夜
                SharedPreferrenceHelper.setTheme(context,"2");
                break;
            case 2:
                //当为黑夜时调用这个方法变成白天
                SharedPreferrenceHelper.setTheme(context,"1");
                break;
            default:
                //默认为白天
                SharedPreferrenceHelper.setTheme(context,"1");
                break;
        }
    }
}
