package com.example.umeng.personter;

import com.example.umeng.Mdelo.RecommendModel;
import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;
import com.example.umeng.interfacer.Classback;
import com.example.umeng.interfacer.IHome;

public class RecommendPersenter implements IHome.Persenter {
    IHome.View view;
    IHome.Mdelo mdelo;

    public RecommendPersenter(IHome.View view) {
        this.view = view;
        this.mdelo =new RecommendModel();
    }

    @Override
    public void getResutop() {
        mdelo.getMdelo(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getDate((RecommendBean) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });

    }

    @Override
    public void getBannere() {
        mdelo.getMdelo2(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getData((Bannere) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }

    @Override
    public void getName() {
        mdelo.getMdelo3(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getName((Items) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }

    @Override
    public void getDiscussed() {
        mdelo.getMdelo4(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getDiscussed((Result) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }

    @Override
    public void getPerson() {
        mdelo.getMdelo5(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getPerson((Person) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }

    @Override
    public void getPopular() {
        mdelo.getMdelo6(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getPopular((Popular) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }

    @Override
    public void getHopBase() {
        mdelo.getMdelo7(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getHopBase((HopBase) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });
    }
}
