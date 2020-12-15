package com.example.umeng.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.umeng.fragmnet.BlankFragment;
import com.example.umeng.fragmnet.BriefBoxinFragment;
import com.example.umeng.fragmnet.HomeFragment;
import com.example.umeng.fragmnet.PingFragment;
import com.example.umeng.fragmnet.SheFragment;
import com.example.umeng.fragmnet.WenFragment;

public class BriefFragmentAdapter  extends FragmentPagerAdapter {
    private String [] mt=new String[]{"关注","推荐","广场","视频","摄影","知识文章"};
    private Context context;
    public BriefFragmentAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==1){
            return new HomeFragment();
        }else if(position==2){
            return new BlankFragment();
        }else if(position==3){
            return new PingFragment();
        }else if(position==4){
            return new SheFragment();
        }else if(position==5){
            return new WenFragment();
        }
        return new BriefBoxinFragment();
    }


    @Override
    public int getCount() {
        return mt.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mt[position];
    }
}
