package com.example.umeng.Mdelo;

import android.util.Log;

import com.example.umeng.api.TongpaoApi;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.interfacer.Classback;
import com.example.umeng.interfacer.IHome;
import com.example.umeng.net.HttpManage;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecommendModel implements IHome.Mdelo {
    private static final String TAG = "RecommendModel";

    @Override
    public void getMdelo(final Classback classback) {
        TongpaoApi tongpaoApi = HttpManage.getHttpManage().getTongpaoApi();
        tongpaoApi.getCity().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Observer<RecommendBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RecommendBean recommendBean) {
                classback.onSecc(recommendBean);
                Log.d(TAG, "onNext: " + recommendBean);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getMdelo2(final Classback classback) {
        TongpaoApi tongpaoApi = HttpManage.getHttpManage().getTongpaoApi();
        tongpaoApi.getDate().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Bannere>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bannere bannere) {
                        classback.onSecc(bannere);
                        Log.d(TAG, "onNextp: " + bannere);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMdelo3(final Classback classback) {
        TongpaoApi tongpaoApi = HttpManage.getHttpManage().getTongpaoApi();
        tongpaoApi.getName().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Items>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Items items) {
                        classback.onSecc(items);
                        Log.d(TAG, "onName: " + items);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getMdelo4(final Classback classback) {
        TongpaoApi tongpaoApi = HttpManage.getHttpManage().getTongpaoApi();
        tongpaoApi.getDiscussed().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        classback.onSecc(result);
                        Log.d(TAG, "onDisposable: " + result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getMdelo5(final Classback classback) {
        TongpaoApi tongpaoApi = HttpManage.getHttpManage().getTongpaoApi();
        tongpaoApi.getPerson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Person>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Person person) {
                        classback.onSecc(person);
                        Log.d(TAG, "onNext: " + person);
                    }

                    @Override
                    public void onError(Throwable e) {
                        classback.onFrom(e.toString());
                        Log.d(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMdelo6(final Classback classback) {
        HttpManage.getHttpManage().getTongpaoApi()
                .getPopular()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Popular>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Popular popular) {
                        classback.onSecc(popular);
                        Log.d(TAG, "onNext3: "+popular);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMdelo7(final Classback classback) {
        HttpManage.getHttpManage().getTongpaoApi()
                .getHopBase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HopBase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HopBase hopBase) {
                        classback.onSecc(hopBase);
                        Log.d(TAG, "onNext33: "+hopBase);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError333: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
