package com.example.bwie.newsdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bwie.newsdemo.R;
import com.example.bwie.newsdemo.bean.MyBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<MyBean.ResultBean.DataBean> list = new ArrayList<>();
    final int one = 0;
    final int two = 1;

    public MyBaseAdapter(Context context, List<MyBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int p = position % 6;
        if (p == 0) {
            return two;
        } else {
            return one;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case one:
                    holder1 = new ViewHolder1();
                    convertView = View.inflate(context, R.layout.item, null);
                    holder1.thumbnail_pic_s = (ImageView) convertView.findViewById(R.id.thumbnail_pic_s);
                    holder1.title = (TextView) convertView.findViewById(R.id.title);
                    holder1.data = (TextView) convertView.findViewById(R.id.data);
                    convertView.setTag(holder1);
                    break;
                case two:
                    holder2 = new ViewHolder2();
                    convertView = View.inflate(context, R.layout.item2, null);
                    holder2.thumbnail_pic_s = (ImageView) convertView.findViewById(R.id.thumbnail_pic_s);
                    holder2.thumbnail_pic_s02 = (ImageView) convertView.findViewById(R.id.thumbnail_pic_s02);
                    holder2.thumbnail_pic_s03 = (ImageView) convertView.findViewById(R.id.thumbnail_pic_s03);
                    holder2.title = (TextView) convertView.findViewById(R.id.title);
                    holder2.data = (TextView) convertView.findViewById(R.id.data);
                    convertView.setTag(holder2);
                    break;
            }
        } else {
            switch (type) {
                case one:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case two:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }
        switch (type) {
            case one:
                holder1.title.setText(list.get(position).title);
                holder1.data.setText(list.get(position).date);
                ImageOptions options = new ImageOptions.Builder()
                        //设置图片的大小
                        .setSize(300, 300)
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                        .setCrop(true)
                        // 加载中或错误图片的ScaleType
                        //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        //设置加载过程中的图片
                        .setLoadingDrawableId(R.mipmap.ic_launcher)
                        //设置加载失败后的图片
                        .setFailureDrawableId(R.mipmap.ic_launcher)
                        //设置使用缓存
                        .setUseMemCache(true)
                        //设置支持gif
                        .setIgnoreGif(false).build();
                //设置显示圆形图片
                // .setCircular(true).build();
                x.image().bind(holder1.thumbnail_pic_s, list.get(position).thumbnail_pic_s, options);
                break;
            case two:
                holder2.title.setText(list.get(position).title);
                holder2.data.setText(list.get(position).date);
                ImageOptions options2 = new ImageOptions.Builder()
                        //设置图片的大小
                        .setSize(300, 300)
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                        .setCrop(true)
                        // 加载中或错误图片的ScaleType
                        //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        //设置加载过程中的图片
                        .setLoadingDrawableId(R.mipmap.ic_launcher)
                        //设置加载失败后的图片
                        .setFailureDrawableId(R.mipmap.ic_launcher)
                        //设置使用缓存
                        .setUseMemCache(true)
                        //设置支持gif
                        .setIgnoreGif(false).build();
                //设置显示圆形图片
                // .setCircular(true).build();
                x.image().bind(holder2.thumbnail_pic_s, list.get(position).thumbnail_pic_s, options2);
                x.image().bind(holder2.thumbnail_pic_s02, list.get(position).thumbnail_pic_s02, options2);
                x.image().bind(holder2.thumbnail_pic_s03, list.get(position).thumbnail_pic_s03, options2);
                break;
        }
        return convertView;
    }

    class ViewHolder1 {
        ImageView thumbnail_pic_s;
        TextView title, data;
    }

    class ViewHolder2 {
        ImageView thumbnail_pic_s, thumbnail_pic_s02, thumbnail_pic_s03;
        TextView title, data;
    }
}
