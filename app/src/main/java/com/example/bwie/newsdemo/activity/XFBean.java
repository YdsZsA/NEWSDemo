package com.example.bwie.newsdemo.activity;

import java.util.ArrayList;

/**
 * date:2016/11/3
 * author:李思儒(dell)
 * function:用来存放讯飞语音的识别结果的JSON数据
 */
public class XFBean {
    public ArrayList<WS> ws;
    public class WS{
        public ArrayList<CW> cw;
    }
    public class CW{
        public String w;
    }

}
