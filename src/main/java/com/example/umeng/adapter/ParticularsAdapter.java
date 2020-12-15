package com.example.umeng.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.R;
import com.example.umeng.base.RecommendBean;

import java.util.List;

public class ParticularsAdapter extends BaseAdapter {
    public ParticularsAdapter(List mData, Context context) {
        super(mData, context);
    }

    @Override
    protected int getLatyou() {
        return R.layout.layout_cont;
    }

    @Override
    protected void bind(Object date, VH vh) {
        RecommendBean.DataBean.PostDetailBean.LikeDetailsBean likeDetailsBean= (RecommendBean.DataBean.PostDetailBean.LikeDetailsBean) date;
        ImageView iv_img_3 = (ImageView) vh.getViewByid(R.id.iv_img_3);
        TextView tv_name_3 = (TextView) vh.getViewByid(R.id.tv_name_3);
        TextView tv_time_2 = (TextView) vh.getViewByid(R.id.tv_tuil_2);
//        TextView tv_text_3 = (TextView) vh.getViewByid(R.id.tv_text_3);
        Glide.with(vh.itemView).load(likeDetailsBean.getHeadUrl()).apply(new RequestOptions().circleCrop()).into(iv_img_3);
        tv_name_3.setText(likeDetailsBean.getNickName());
        tv_time_2.setText(likeDetailsBean.getLikeTime());


    }
}
