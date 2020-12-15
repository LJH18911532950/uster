package com.example.umeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.umeng.R;
import com.example.umeng.base.HopBase;

import java.util.List;

public class HopAdapter extends RecyclerView.Adapter {

    private List<HopBase.DataBean.ListBean> listBeans;
    private Context context;

    public HopAdapter(List<HopBase.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_hop, parent, false);
            return new MyHome(view);
        }
        if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_hop2, parent, false);
            return new MyItem(view);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.layout_hop3, parent, false);
        return new VH(view);


    }

    private static final String TAG = "HopAdapter";
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            MyHome myHome= (MyHome) holder;
            myHome.textView1.setText(listBeans.get(position).getTitle());
            myHome.textView2.setText(listBeans.get(position).getCreateTime());
            Glide.with(context).load(listBeans.get(position).getFilePathList().get(0).getFilePath()).into(myHome.imageView1);
            Glide.with(context).load(listBeans.get(position).getFilePathList().get(1).getFilePath()).into(myHome.imageView2);
            Glide.with(context).load(listBeans.get(position).getFilePathList().get(2).getFilePath()).into(myHome.imageView3);
        }
        if(itemViewType==2){
            MyItem myItem= (MyItem) holder;
            myItem.textView3.setText(listBeans.get(position).getTitle());
            myItem.textView4.setText(listBeans.get(position).getCreateTime());
            Glide.with(context).load(listBeans.get(position).getFilePathList().get(0).getFilePath()).into(myItem.imageView4);

        }
        if(itemViewType==3){
            VH vh= (VH) holder;
            vh.textView5.setText(listBeans.get(position).getTitle());
            vh.textView6.setText(listBeans.get(position).getCreateTime());

        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 1;
        } else if (position % 3 == 1) {
            return 2;
        } else {
            return 3;
        }
    }


    @Override
    public int getItemCount() {
        return listBeans.size();
    }
    class MyHome extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private ImageView imageView1;
        private ImageView imageView2;
        private ImageView imageView3;
        public MyHome(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.tv_s1);
            textView2=itemView.findViewById(R.id.tv_sj);
            imageView1=itemView.findViewById(R.id.iv_images1);
            imageView2=itemView.findViewById(R.id.iv_images2);
            imageView3=itemView.findViewById(R.id.iv_images3);
        }
    }
    class MyItem extends RecyclerView.ViewHolder{
        private TextView textView3;
        private TextView textView4;
        private ImageView imageView4;
        public MyItem(@NonNull View itemView) {
            super(itemView);
            textView3=itemView.findViewById(R.id.tv_twer1);
            textView4=itemView.findViewById(R.id.tv_twer2);
            imageView4=itemView.findViewById(R.id.iv_images4);
        }
    }
    class VH extends RecyclerView.ViewHolder{
        private TextView textView5;
        private TextView textView6;
        public VH(@NonNull View itemView) {
            super(itemView);
            textView5=itemView.findViewById(R.id.tv_twer3);
            textView6=itemView.findViewById(R.id.tv_twer4);
        }
    }


}
