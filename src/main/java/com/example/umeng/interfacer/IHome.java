package com.example.umeng.interfacer;

import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;

public interface IHome {
    interface View {
        void getDate(RecommendBean recommendBean);
        void getData(Bannere bannere);
        void getName(Items item);
        void getDiscussed(Result result);
        void getPerson(Person person);
        void getPopular(Popular popular);
        void getHopBase(HopBase hopBase);
    }
    interface Persenter{
        void getResutop();
        void getBannere();
        void getName();
        void getDiscussed();
        void getPerson();
        void getPopular();
        void getHopBase();
    }
    interface Mdelo{
        void getMdelo(Classback classback);
        void getMdelo2(Classback classback);
        void getMdelo3(Classback classback);
        void getMdelo4(Classback classback);
        void getMdelo5(Classback classback);
        void getMdelo6(Classback classback);
        void getMdelo7(Classback classback);
    }
}
