package com.example.umeng;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView txtReturn;
    private TextView txtPage;
    private TextView txtDown;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        txtReturn = (TextView) findViewById(R.id.txt_return);
        txtPage = (TextView) findViewById(R.id.txt_page);
        txtDown = (TextView) findViewById(R.id.txt_down);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        final Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        final ArrayList<String> imgs = bundle.getStringArrayList("urls");
        int index = bundle.getInt("postion");

        txtReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgs.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view= LayoutInflater.from(HomeActivity.this).inflate(R.layout.layout_title,null);

                PhotoView imageView = view.findViewById(R.id.Pane);
                String s = imgs.get(position);
                Glide.with(view).load(s).into(imageView);
                container.addView(view);
                imageView.enable();//设置是否允许缩放，默认是不允许的
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
        viewPager.setCurrentItem(index);

    }
}