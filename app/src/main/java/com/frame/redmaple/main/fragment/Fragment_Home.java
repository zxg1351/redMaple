package com.frame.redmaple.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.HomeBean;
import com.frame.redmaple.base.util.RecycleViewDivider;
import com.frame.redmaple.base.util.bannerViewPage.RollPagerView;
import com.frame.redmaple.main.adapter.RMHomeAdapter;
import com.frame.redmaple.main.adapter.ImageLoopAdapter;
import com.frame.redmaple.main.adapter.RaiseAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.frame.redmaple.R.color.Hf10e50;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Home extends Fragment {

    private TextView tv_title;
    private FragmentManager manager;
    private RollPagerView mViewPager;
    ImageLoopAdapter imageLoopAdapter;
    List<String> imgList = new ArrayList<>();
    //    private RecyclerView rv_home;
    private RMHomeAdapter homeAdapter;
    private List<String> mDatas;
    List<Integer> ipImages = new ArrayList<>();
    HomeBean homeBean = new HomeBean();
    private ListView lv_view;

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
        initData();
//        homeAdapter = new RMHomeAdapter(getContext(), mDatas, getImageList());
//        homeAdapter = new RMHomeAdapter(getContext(), getHomeBean());
//        rv_home = (RecyclerView) view.findViewById(R.id.rv_home);
        lv_view = (ListView) view.findViewById(R.id.lv_view);
        RaiseAdapter raiseAdapter = new RaiseAdapter(getContext(), mDatas, getImageList());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        lv_view.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 2, Hf10e50));
//        lv_view.setLayoutManager(linearLayoutManager);
//        rv_home.setLayoutManager(new GridLayoutManager(getContext(), 3));
        lv_view.setAdapter(raiseAdapter);
    }

    public List<String> getDatas() {


        imgList.add("http://img2.3lian.com/2014/f6/173/d/51.jpg");
        imgList.add("http://www.hanhande.com/upload/151230/1283568_105451_1.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490169306212&di=fbf8b98fca9c9f1036a41aa3d62277b1&imgtype=0&src=http%3A%2F%2Fpic17.nipic.com%2F20111014%2F7050178_140001986000_2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490169330545&di=a6050448fe99ebe66ea51ddb72ac4514&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F94cad1c8a786c91743d61a36cb3d70cf3ac757e3.jpg");
        return imgList;
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'F'; i++) {
            mDatas.add("" + (char) i + "图片");
        }
    }

    //
//
    private List<Integer> getImageList() {

//        ipImages.add(R.mipmap.ic_one);
//        ipImages.add(R.mipmap.ic_two);
//        ipImages.add(R.mipmap.ic_three);
//        ipImages.add(R.mipmap.ic_four);
//        ipImages.add(R.mipmap.ic_five);
        ipImages.add(R.mipmap.ic_launcher);
        ipImages.add(R.mipmap.ic_launcher);
        ipImages.add(R.mipmap.ic_launcher);
        ipImages.add(R.mipmap.ic_launcher);
        ipImages.add(R.mipmap.ic_launcher);
        return ipImages;
    }

//    private List<HomeBean> getHomeBean() {
//
//        List<HomeBean> homeBeenList = new ArrayList<>();
//        mDatas = new ArrayList<String>();
//        for (int i = 'A'; i < 'E'; i++) {
//            mDatas.add("" + (char) i + "图片");
//
//            ipImages.add(R.mipmap.ic_one);
//
//        }
//        homeBean.setmDatas(mDatas);
//        homeBean.setIpImages(ipImages);
//        homeBeenList.add(homeBean);
//        return homeBeenList;
//    }
}
