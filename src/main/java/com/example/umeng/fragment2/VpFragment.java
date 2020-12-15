package com.example.umeng.fragment2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VpFragment extends FragmentPagerAdapter {
    private String[] su=new String[]{"关注","推荐","活动","社团","文章"};
    private Context context;

    public VpFragment(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       if(position==1){
           return new VpFragment2();
       }
       return new VpFragment1();
    }


    @Override
    public int getCount() {
        return su.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return su[position];
    }
}
