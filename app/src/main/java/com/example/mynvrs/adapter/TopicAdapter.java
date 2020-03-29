package com.example.mynvrs.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.mynvrs.R;
import com.example.mynvrs.base.BaseAdapter;
import com.example.mynvrs.models.bean.TopicBean;

import java.util.List;

public class TopicAdapter extends BaseAdapter {

    public TopicAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.topic_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        TopicBean.DataBean.TopicListBean topicListBean= (TopicBean.DataBean.TopicListBean) o;
        ImageView image = (ImageView) holder.getView(R.id.special_iv);
        TextView special_tv_black = (TextView) holder.getView(R.id.special_tv_black);
        TextView special_tv_gray = (TextView) holder.getView(R.id.special_tv_gray);
        TextView special_tv_red = (TextView) holder.getView(R.id.special_tv_red);
        Glide.with(mContext).load(topicListBean.getItem_pic_url()).into(image);
        special_tv_black.setText(topicListBean.getTitle());
        special_tv_gray.setText(topicListBean.getSubtitle());
        special_tv_red.setText(topicListBean.getPrice_info()+"元起");

    }
}
