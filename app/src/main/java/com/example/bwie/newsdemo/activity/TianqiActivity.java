package com.example.bwie.newsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.bwie.newsdemo.R;
import com.umeng.socialize.utils.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * data 2017/8/15.
 * author:赵鑫
 * function:
 */

public class TianqiActivity extends AppCompatActivity {
    private TextView day_tianqi;
    private TextView tianqi;
    private TextView wendu_tianqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tianqi);
        initView();

        initdata();

    }
    private void initdata() {
        new Thread() {

            private String feng;
            private String hight;
            private String wendu1;
            private String tianqi1;
            private String day;

            @Override
            public void run() {
                try {
                    //从一个URL加载一个Document对象。
                    Document doc = Jsoup.connect("http://www.weather.com.cn/weather/101010100.shtml").get();
                    //选择天气节点
                    Elements elements1 = doc.select("div.c7d");
                    Elements elements2 = doc.select("div.c7d");
                    Elements elements3 = doc.select("div.c7d");
                    Elements elements4 = doc.select("div.c7d");
                    Elements elements5 = doc.select("div.c7d");
                    //打印 <a>标签里面的title
                    day = elements1.select("h1").get(0).text();//获取的是日期
                    tianqi1 = elements2.select("p").attr("title");//获取的天气
                    wendu1 = elements3.select("span").get(0).text();//获取最低温度
                    hight = elements4.select("i").get(0).text();//获取最高温度
                    feng = elements5.select("span").attr("title");//获取风向

                    Log.d("tainqi",tianqi1);
                    TianqiActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            day_tianqi.setText(day);
                            tianqi.setText(tianqi1);
                            wendu_tianqi.setText("最高温度："+wendu1+"    最低温度："+hight+"    风向："+feng);
                        }
                    });
                } catch (Exception e) {
                }

            }
        }.start();

    }

    private void initView() {
        day_tianqi = (TextView) findViewById(R.id.day_tianqi);
        tianqi = (TextView) findViewById(R.id.tianqi);
        wendu_tianqi = (TextView) findViewById(R.id.wendu_tianqi);
    }
}
