package com.example.umeng.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.umeng.R;
import com.example.umeng.adapter.BriefFragmentAdapter;
import com.google.android.material.tabs.TabLayout;


public class BlankFragment_1 extends Fragment {


    private TabLayout tab;
    private ViewPager vp;

    public BlankFragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tab);
        vp = (ViewPager) view.findViewById(R.id.vp);

        BriefFragmentAdapter briefFragmentAdapter = new BriefFragmentAdapter(getFragmentManager(), getContext());
        vp.setAdapter(briefFragmentAdapter);
        tab.setupWithViewPager(vp);
        vp.setCurrentItem(1);
        tab.getTabAt(1).select();
    }
}