package com.example.umeng.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.HomeActivity;
import com.example.umeng.PersonalActivity;
import com.example.umeng.R;
import com.example.umeng.base.RecommendBean;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.List;


public class ClasxAdaptret extends BaseAdapter {

    private List<String> imgsm;

    public ClasxAdaptret(List mData, Context context) {
        super(mData, context);
    }

    @Override
    protected int getLatyou() {
        return R.layout.layout;
    }

    @Override
    protected void bind(Object date, final VH vh) {
        final RecommendBean.DataBean.PostDetailBean detailBean = (RecommendBean.DataBean.PostDetailBean) date;
        ImageView iv_img_1 = (ImageView) vh.getViewByid(R.id.iv_img_1);
        TextView tv_title = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tv_tuil_1 = (TextView) vh.getViewByid(R.id.tv_tuil_1);
        ExpandableTextView ex_text = (ExpandableTextView) vh.getViewByid(R.id.expand_text_view);
        //TextView tv_text = (TextView) vh.getViewByid(R.id.expandable_text);
        final Button btn_asd = (Button) vh.getViewByid(R.id.btn_asd);
        RequestOptions requestOptions = new RequestOptions()
                .circleCrop();
        Glide.with(vh.itemView).load(detailBean.getHeadUrl()).apply(requestOptions).into(iv_img_1);
        tv_title.setText(detailBean.getNickName());
        tv_tuil_1.setText(detailBean.getCreateTime());
        ex_text.setText(detailBean.getContent());

        String s = ex_text.getText().toString();
        int start = s.indexOf("@");
        int endPos = s.lastIndexOf(" ") + 1;
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(s);
        stringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), start, endPos, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        //tv_text.setMovementMethod(LinkMovementMethod.getInstance());
        ex_text.setText(stringBuilder);

        NineGridImageView ninegrid = (NineGridImageView) vh.getViewByid(R.id.niv);
        imgsm = new ArrayList<>();
        for (int i = 0; i < detailBean.getImages().size(); i++) {
            String filePath = ((RecommendBean.DataBean.PostDetailBean) date).getImages().get(i).getFilePath();
            imgsm.add(filePath);
        }
        ninegrid.setAdapter(new NineGridImageViewAdapter() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, Object o) {
                Glide.with(context).load(o).into(imageView);

            }

            @Override
            protected void onItemImageClick(Context context, int index, List list) {
                //点击查看大图
                super.onItemImageClick(context, index, list);
                Intent intent = new Intent(context, HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("postion", index);
                bundle.putStringArrayList("urls", (ArrayList<String>) imgsm);
                intent.putExtra("data", bundle);
                context.startActivity(intent);


            }
        });
        ninegrid.setImagesData(imgsm);

        iv_img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick45: "+"456465");
                Intent intent = new Intent(v.getContext(), PersonalActivity.class);
                intent.putExtra("url",detailBean.getHeadUrl());
                intent.putExtra("nic",detailBean.getNickName());
                v.getContext().startActivity(intent);
            }
        });

    }

}
