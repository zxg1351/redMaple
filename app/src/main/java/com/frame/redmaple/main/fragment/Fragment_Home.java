package com.frame.redmaple.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Home extends Fragment {

    private TextView tv_title;
    private FragmentManager manager;

    public Fragment_Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("首页");
        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));
        return view;


    }

}
