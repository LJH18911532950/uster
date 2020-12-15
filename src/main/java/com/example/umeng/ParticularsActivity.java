package com.example.umeng;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.umeng.adapter.ParticularsAdapter;
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

public class ParticularsActivity extends AppCompatActivity implements IHome.View {

    private Toolbar tooble;
    private ImageView ivImg2;
    private TextView tvName2;
    private TextView tvTime;
    private TextView tvText2;
    private RecyclerView recyclerviews;
    private IHome.Persenter recommendPersenter;
    private List<RecommendBean.DataBean.PostDetailBean.LikeDetailsBean> likeDetailsBeans;
    private ParticularsAdapter adapter;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        recommendPersenter = new RecommendPersenter(this);
        initView();
        initDate();
    }

    private void initDate() {
        recommendPersenter.getResutop();
    }

    private void initView() {
        tooble = (Toolbar) findViewById(R.id.tooble);
        ivImg2 = (ImageView) findViewById(R.id.iv_img_2);
        tvName2 = (TextView) findViewById(R.id.tv_name_2);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvText2 = (TextView) findViewById(R.id.tv_text_2);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tooble.setTitle(" ");
        setSupportActionBar(tooble);

        Intent intent = getIntent();
        String name = intent.getStringExtra("HeadUrl");
        String NickName = intent.getStringExtra("NickName");
        String CreateTime = intent.getStringExtra("CreateTime");
        String Content = intent.getStringExtra("Content");
        Glide.with(this).load(name).apply(new RequestOptions().circleCrop()).into(ivImg2);
        tvName2.setText(NickName);
        tvTime.setText(CreateTime);
        tvText2.setText(Content);

        String s1 = tvText2.getText().toString();
        final int start = s1.indexOf("@");
        int endPos = s1.lastIndexOf(" ") + 1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(s1);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), start, endPos, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tvText2.setMovementMethod(LinkMovementMethod.getInstance());
        //tvText2.setMovementMethod(LinkMovementMethod.getInstance());
        tvText2.setText(spannableStringBuilder);


        recyclerviews = (RecyclerView) findViewById(R.id.recyclerviews);
        recyclerviews.setLayoutManager(new LinearLayoutManager(this));
        likeDetailsBeans = new ArrayList<>();
        adapter = new ParticularsAdapter(likeDetailsBeans, this);
        recyclerviews.setAdapter(adapter);
        recyclerviews.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"1");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getDate(RecommendBean recommendBean) {
        List<RecommendBean.DataBean.PostDetailBean.LikeDetailsBean> details = recommendBean.getData().getPostDetail().getLikeDetails();
        likeDetailsBeans.addAll(details);
        adapter.notifyDataSetChanged();
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

    }
}