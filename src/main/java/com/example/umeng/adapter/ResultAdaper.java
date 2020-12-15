package com.example.umeng.adapter;

import android.content.Context;
import android.util.TimeUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.R;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.Items;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.utils.TxtUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultAdaper extends BaseAdapter {


    public ResultAdaper(List mData, Context context) {
        super(mData, context);
    }

    @Override
    protected int getLatyou() {
        return R.layout.layout_loing;
    }

    @Override
    protected void bind(final Object date, VH vh) {
        Result.DataBean dataBean= (Result.DataBean) date;
        ImageView viewByid = (ImageView) vh.getViewByid(R.id.iv_img);
        RequestOptions transform = new RequestOptions()
                .transform(new RoundedCorners(26));

        Glide.with(vh.itemView).load(dataBean.getImageUrl()).apply(transform).into(viewByid);
        TextView viewByid1 = (TextView) vh.getViewByid(R.id.tv_name);
        TextView viewByid2 = (TextView) vh.getViewByid(R.id.tv_count);
        viewByid1.setText(dataBean.getName());
        TxtUtils.setTextView(viewByid2,dataBean.getAttentionNum()+"人参与");

    }
}
