package com.example.umeng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class TutilActivity extends AppCompatActivity {

    private Button btnQwer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutil);
        initView();
    }

    private void initView() {
        btnQwer = (Button) findViewById(R.id.btn_qwer);
        final Disposable disposable = Observable.intervalRange(0, 6, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        long j = 5 - aLong;
                        btnQwer.setText(j+"s");
                        if (j == 0) {
                            Intent intent = new Intent(TutilActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
        btnQwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutilActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                disposable.dispose();
            }
        });

    }
}