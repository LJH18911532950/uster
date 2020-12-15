package com.example.umeng;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.fragment2.VpFragment;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.personter.RecommendPersenter;
import com.google.android.material.tabs.TabLayout;

public class PersonalActivity extends AppCompatActivity implements IHome.View {

    private ViewPager vp2;
    private IHome.Persenter persenter;
    private TabLayout tool2;
    private ImageView ivImg4;
    private TextView tvName4;
    private Button btnZxc;
    private Button btnBnm;
    private TextView tvTest;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_adapter);
        persenter = new RecommendPersenter(this);
        initDate();
        initView();
    }

    private void initDate() {
        persenter.getPerson();

    }

    private void initView() {

        ivImg4 = (ImageView) findViewById(R.id.iv_img_4);
        tvName4 = (TextView) findViewById(R.id.tv_name_4);
        btnZxc = (Button) findViewById(R.id.btn_zxc);
        btnBnm = (Button) findViewById(R.id.btn_bnm);
        vp2 =  findViewById(R.id.vp2);
        tool2 =  findViewById(R.id.tool_bar);
        tvTest=findViewById(R.id.tv_test);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String nic = intent.getStringExtra("nic");
        Glide.with(this).load(url).apply(new RequestOptions().circleCrop()).into(ivImg4);
        tvName4.setText(nic);

        VpFragment fragment = new VpFragment(getSupportFragmentManager(), this);
        vp2.setAdapter(fragment);
        tool2.setupWithViewPager(vp2);

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
        tvTest.setText(data.getSignature());
        tv1.setText(data.getOrgstatus());
        tv2.setText(data.getDynamicnumber());
        tv3.setText(data.getContactMe());

    }

    @Override
    public void getPopular(Popular popular) {

    }

    @Override
    public void getHopBase(HopBase hopBase) {

    }
}