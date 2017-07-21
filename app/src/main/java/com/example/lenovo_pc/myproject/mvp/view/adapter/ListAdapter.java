package com.example.lenovo_pc.myproject.mvp.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifyBean;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/7/19 21:55
 * 功能：
 */

public class ListAdapter extends BaseAdapter {
    private List<ClassifyBean.DatasBean.ClassListBean> list = new ArrayList();
    private Context context;

    public ListAdapter(Context context, List<ClassifyBean.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ClassifyBean.DatasBean.ClassListBean getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.image_text, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.Text_View);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.Image_View);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(i).getGc_name());
        x.image().bind(viewHolder.imageView, getItem(i).getImage());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
