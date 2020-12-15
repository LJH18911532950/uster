package com.example.umeng.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.umeng.R;

public class BlankFragment extends Fragment {


    private TextView t1;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        t1 = view.findViewById(R.id.t1);
        t1.setText(" OK，大家看博客开始时的gif图，当图片折叠时，其实是图片的顶部一直在慢慢的隐藏，底部并没有动，那么如果你想要修改这个效果，可以使用下面的属性：\n" +
                "\n" +
                "app:layout_collapseMode=\"parallax\"表示ImageView的折叠和CollapsingToolbarLayout的折叠不同步，那么这个不同步到底是怎样一个不同步法呢？还有另外一个参数来设置不同步的参数，如下：\n" +
                "\n" +
                "app:layout_collapseParallaxMultiplier=\"0.5\"表示视觉乘数，该数值的取值为0～1，数值越大，视觉差越大（如果这里的值为0，则在头部折叠的过程中，ImageView的顶部在慢慢隐藏，底部不动，如果这里的值为1，ImageView的顶部不懂，底部慢慢隐藏，如果这里的取值为0～1之间，则在折叠的过程中，ImageView的顶部和底部都会隐藏，但是头部和底部隐藏的快慢是不一样的，具体速度和视觉乘数有关）\n" +
                "\n" +
                "app:layout_collapseMode这个属性还有一个取值，是pin，该属性表示当折叠完成时将该控件放在页面的头部.\n" +
                "\n" +
                "OK ，配合上上面这几种属性，我们的一个较完整的头部应该是这样的：");


    }

}