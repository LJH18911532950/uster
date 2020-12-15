package com.example.umeng.fragmnet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.umeng.ParticularsActivity;
import com.example.umeng.R;
import com.example.umeng.adapter.BaseAdapter;
import com.example.umeng.adapter.ClasxAdaptret;
import com.example.umeng.adapter.ResultAdaper;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.personter.RecommendPersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements IHome.View {


    private ResultAdaper resultAdaper;
    private List<Result.DataBean> dataBeans;
    private ClasxAdaptret clasxAdaptret;
    private Banner bannereop;
    private RecyclerView recyler;
    private RecyclerView recyler2;
    private RecyclerView recyler3;

    public HomeFragment() {
        // Required empty public constructor
    }


    private IHome.Persenter persenter;
    private List<RecommendBean.DataBean.PostDetailBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        persenter = new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initView(View view) {
        bannereop = (Banner) view.findViewById(R.id.bannere);
        recyler = (RecyclerView) view.findViewById(R.id.recyler);
        recyler2 = (RecyclerView) view.findViewById(R.id.recyler2);
        recyler3 = (RecyclerView) view.findViewById(R.id.recyler3);
        recyler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false ));
        recyler2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyler3.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        dataBeans=new ArrayList<>();
        resultAdaper = new ResultAdaper(dataBeans, getContext());
        resultAdaper.setTextClass(new BaseAdapter.TextClass() {
            @Override
            public void TextClass(int position) {
                Result.DataBean dataBean = dataBeans.get(position);
                String name = dataBean.getName();
                Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
        recyler.setAdapter(resultAdaper);
        clasxAdaptret=new ClasxAdaptret(list,getContext());
        clasxAdaptret.setTextClass(new BaseAdapter.TextClass() {
            @Override
            public void TextClass(int position) {
                Intent intent = new Intent(getContext(), ParticularsActivity.class);
                RecommendBean.DataBean.PostDetailBean postDetailBean = list.get(position);
                intent.putExtra("HeadUrl", postDetailBean.getHeadUrl());
                intent.putExtra("NickName", postDetailBean.getNickName());
                intent.putExtra("CreateTime", postDetailBean.getCreateTime());
                intent.putExtra("Content", postDetailBean.getContent());
                startActivity(intent);
            }
        });
        recyler2.setAdapter(clasxAdaptret);
    }


    private void initDate() {
        persenter.getResutop();
        persenter.getBannere();
        persenter.getName();
        persenter.getDiscussed();
    }

    private static final String TAG = "MainActivity";

    @Override
    public void getDate(RecommendBean recommendBean) {
        RecommendBean.DataBean.PostDetailBean postDetail = recommendBean.getData().getPostDetail();
        Log.d(TAG, "getDate2: " + postDetail.getContent());
        list.add(postDetail);
        clasxAdaptret.notifyDataSetChanged();
    }

    @Override
    public void getData(Bannere bannere) {
        Log.d(TAG, "getData: " + bannere);
        List<Bannere.DataBean.ListBean> list = bannere.getData().getList();

        bannereop.setImages(list);
        bannereop.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Bannere.DataBean.ListBean dd = (Bannere.DataBean.ListBean) path;
                Glide.with(context).load(dd.getBanner()).into(imageView);
            }
        }).start();
    }

    @Override
    public void getName(Items item) {

    }

    @Override
    public void getDiscussed(Result result) {
        List<Result.DataBean> data = result.getData();
        dataBeans.addAll(data);
        resultAdaper.notifyDataSetChanged();
    }

    @Override
    public void getPerson(Person person) {

    }

    @Override
    public void getPopular(Popular popular) {

    }

    @Override
    public void getHopBase(HopBase hopBase) {

    }
}