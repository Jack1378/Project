package com.example.lenovo_pc.myproject.mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:46
 * 功能：RecyclerView的适配器(二级列表)
 */

public class RecyclerSecondAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private List<ClassifyBean.DatasBean.ClassListBean> News_List;
    private OnItemClickListener mOnItemClickListener = null;

    public RecyclerSecondAdapter(Context mContext) {
        this.context = mContext;
        News_List = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        //注意这里使用getTag方法获取position
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.image_texts, null);
        ViewHolder vi = new ViewHolder(view);
        view.setOnClickListener(this);
        return  vi;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(News_List.get(position).getGc_name());
        //将position保存在itemView的Tag中，以便点击时进行获取
        viewHolder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return News_List.size();
    }

    public void setData(List<ClassifyBean.DatasBean.ClassListBean> data) {
        if (data != null) {
            News_List.addAll(data);
            notifyDataSetChanged();
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.Text_View2);
        }
    }


}
