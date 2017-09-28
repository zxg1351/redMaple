package com.frame.redmaple.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.util.bannerViewPage.RollPagerView;
import com.frame.redmaple.main.adapter.ImageLoopAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Home extends Fragment {

    private TextView tv_title;
    private FragmentManager manager;
    private RollPagerView mViewPager;
    ImageLoopAdapter imageLoopAdapter;
    List<String> imgList = new ArrayList<>();

    public Fragment_Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("首页");

        initView(view);


        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));
        return view;


    }

    private void initView(View view) {

        mViewPager = (RollPagerView) view.findViewById(R.id.vp_image);
        imageLoopAdapter = new ImageLoopAdapter(mViewPager, getContext(), getDatas());

        mViewPager.setAdapter(imageLoopAdapter);
    }

    public List<String> getDatas() {


        imgList.add("http://img2.3lian.com/2014/f6/173/d/51.jpg");
        imgList.add("http://www.hanhande.com/upload/151230/1283568_105451_1.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490169306212&di=fbf8b98fca9c9f1036a41aa3d62277b1&imgtype=0&src=http%3A%2F%2Fpic17.nipic.com%2F20111014%2F7050178_140001986000_2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490169330545&di=a6050448fe99ebe66ea51ddb72ac4514&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F94cad1c8a786c91743d61a36cb3d70cf3ac757e3.jpg");
        return imgList;
    }
}
