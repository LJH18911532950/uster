package com.example.umeng;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.umeng.fragmnet.BlankFragment_1;
import com.example.umeng.fragmnet.BlankFragment_2;
import com.example.umeng.fragmnet.BlankFragment_3;
import com.example.umeng.fragmnet.BlankFragment_4;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frames;
    private TabLayout tabs;
    private BlankFragment_1 blankFragment_1;
    private BlankFragment_2 blankFragment_2;
    private BlankFragment_3 blankFragment_3;
    private BlankFragment_4 blankFragment_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        frames = (FrameLayout) findViewById(R.id.frames);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("首页").setIcon(R.drawable.shou));
        tabs.addTab(tabs.newTab().setText("发现").setIcon(R.drawable.shou));
        tabs.addTab(tabs.newTab().setText("首页").setIcon(R.drawable.shou));
        tabs.addTab(tabs.newTab().setText("我的").setIcon(R.drawable.shou));
        blankFragment_1 = new BlankFragment_1();
        blankFragment_2 = new BlankFragment_2();
        blankFragment_3 = new BlankFragment_3();
        blankFragment_4 = new BlankFragment_4();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frames, blankFragment_1)
                .add(R.id.frames, blankFragment_2)
                .add(R.id.frames, blankFragment_3)
                .add(R.id.frames, blankFragment_4)
                .show(blankFragment_1)
                .hide(blankFragment_2)
                .hide(blankFragment_3)
                .hide(blankFragment_4)
                .commit();
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment_1)
                                .hide(blankFragment_2)
                                .hide(blankFragment_3)
                                .hide(blankFragment_4)
                                .commit();
                    break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment_2)
                                .hide(blankFragment_1)
                                .hide(blankFragment_3)
                                .hide(blankFragment_4)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment_3)
                                .hide(blankFragment_2)
                                .hide(blankFragment_1)
                                .hide(blankFragment_4)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment_4)
                                .hide(blankFragment_2)
                                .hide(blankFragment_3)
                                .hide(blankFragment_1)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}