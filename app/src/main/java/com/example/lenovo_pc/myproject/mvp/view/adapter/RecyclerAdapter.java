package com.example.lenovo_pc.myproject.mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.NewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:46
 * 功能：RecyclerView的适配器（首页）
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<NewsData.DataBean> News_List;

    public RecyclerAdapter(Context mContext) {
        this.context = mContext;
        News_List = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.image_text, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(News_List.get(position).getNews_title());
        Glide.with(context)
                .load(News_List.get(position).getPic_url())
                .into(((ViewHolder) holder).imageView);

    }

    @Override
    public int getItemCount() {
        return News_List.size();
    }

    public void setData(List<NewsData.DataBean> data) {
        if (data != null) {
            News_List.addAll(data);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.Image_View);
            textView = (TextView) itemView.findViewById(R.id.Text_View);
        }
    }


}
