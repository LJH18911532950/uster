package com.example.umeng.fragment3;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabFragmen extends FragmentPagerAdapter {
    private String[] up=new String[]{"热点","妆造","图鉴","百科"};
    private Context context;
    public TabFragmen(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==1){
            return new MopFragment();
        }
        return new HopFragment();
    }


    @Override
    public int getCount() {
        return up.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return up[position];
    }
}
