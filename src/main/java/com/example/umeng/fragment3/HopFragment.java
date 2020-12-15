package com.example.umeng.fragment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umeng.R;
import com.example.umeng.adapter.HopAdapter;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.personter.RecommendPersenter;

import java.util.ArrayList;
import java.util.List;


public class HopFragment extends Fragment implements IHome.View {

    private static final String TAG = "HopFragment";
    private RecyclerView recys;
    private IHome.Persenter persenter;
    private List<HopBase.DataBean.ListBean> listBeans;
    private HopAdapter adapter;

    public HopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hop, container, false);
        persenter= new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        persenter.getHopBase();
    }

    private void initView(View view) {

        recys = (RecyclerView) view.findViewById(R.id.recys);
        recys.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        adapter = new HopAdapter(listBeans, getContext());
        recys.setAdapter(adapter);
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

    }

    @Override
    public void getHopBase(HopBase hopBase) {
        List<HopBase.DataBean.ListBean> list = hopBase.getData().getList();
        listBeans.addAll(list);
        adapter.notifyDataSetChanged();

    }
}