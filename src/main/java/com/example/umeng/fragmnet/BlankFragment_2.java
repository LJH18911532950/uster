package com.example.umeng.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.umeng.R;
import com.example.umeng.adapter.PersonAdapter;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.fragment3.TabFragmen;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.personter.RecommendPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment_2 extends Fragment implements IHome.View {


    private ImageView ivRobe;
    private ImageView ivMass;
    private ImageView ivRanking;
    private RecyclerView recyclerview;
    private IHome.Persenter persenter;
    private List<Popular.DataBean> dataBeans;
    private PersonAdapter adapter;
    private TabLayout tabl;
    private ViewPager vps;

    public BlankFragment_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_2, container, false);
        persenter = new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        persenter.getPopular();
    }

    private void initView(View view) {
        tabl = (TabLayout) view.findViewById(R.id.tabl);
        vps = (ViewPager) view.findViewById(R.id.vps);
        ivRobe = (ImageView) view.findViewById(R.id.iv_robe);
        ivMass = (ImageView) view.findViewById(R.id.iv_mass);
        ivRanking = (ImageView) view.findViewById(R.id.iv_ranking);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        dataBeans = new ArrayList<>();
        adapter = new PersonAdapter(dataBeans, getContext());
        recyclerview.setAdapter(adapter);
        TabFragmen tabFragmen = new TabFragmen(getFragmentManager(), getContext());
        vps.setAdapter(tabFragmen);
        tabl.setupWithViewPager(vps);
    }

    @Override
    public void getDate(RecommendBean recommendBean) {

    }

    @Override
    public void getData(Bannere bannere) {

    }

    @Override
    public void getName(Items item) {

    }

    @Override
    public void getDiscussed(Result result) {

    }

    @Override
    public void getPerson(Person person) {

    }

    @Override
    public void getPopular(Popular popular) {
        List<Popular.DataBean> data = popular.getData();
        dataBeans.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getHopBase(HopBase hopBase) {

    }
}