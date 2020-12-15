package com.example.umeng.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.R;
import com.example.umeng.base.Popular;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    public PersonAdapter(List mData, Context context) {
        super(mData, context);
    }

    @Override
    protected int getLatyou() {
        return R.layout.layout_person;
    }

    @Override
    protected void bind(Object date, VH vh) {
        Popular.DataBean dataBean= (Popular.DataBean) date;
        ImageView iv_imager = (ImageView) vh.getViewByid(R.id.iv_imager);
        TextView tv_tw = (TextView) vh.getViewByid(R.id.tv_tw);

        Glide.with(vh.itemView).load(dataBean.getCover()).apply(new RequestOptions().transform(new RoundedCorners(26))).into(iv_imager);
        tv_tw.setText(dataBean.getLocation());
    }
}
