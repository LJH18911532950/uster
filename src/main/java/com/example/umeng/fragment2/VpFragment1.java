package com.example.umeng.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.umeng.R;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.personter.RecommendPersenter;


public class VpFragment1 extends Fragment implements IHome.View {

    private IHome.Persenter persenter;
    private TextView count1;
    private TextView count2;
    private TextView count3;
    private TextView count4;
    private TextView count5;

    public VpFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vp1, container, false);
        persenter=new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        persenter.getPerson();
    }

    private void initView(View view) {
        count1 = (TextView) view.findViewById(R.id.count_1);
        count2 = (TextView) view.findViewById(R.id.count_2);
        count3 = (TextView) view.findViewById(R.id.count_3);
        count4 = (TextView) view.findViewById(R.id.count_4);
        count5 = (TextView) view.findViewById(R.id.count_5);
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
        Person.DataBean data = person.getData();
        count1.setText(data.getBirthday());
        count2.setText(data.getBirthday());
        count3.setText(data.getCity());
        count4.setText(data.getProvince());
        count5.setText(data.getProvince());

    }

    @Override
    public void getPopular(Popular popular) {

    }

    @Override
    public void getHopBase(HopBase hopBase) {

    }
}