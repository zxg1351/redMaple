package com.frame.redmaple.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;
import com.frame.redmaple.base.util.RecycleViewDivider;
import com.frame.redmaple.main.activity.Me.RMAboutUsActivity;
import com.frame.redmaple.main.activity.Me.RMCalculatorActivity;
import com.frame.redmaple.main.activity.Me.RMCollectionActivity;
import com.frame.redmaple.main.activity.Me.RMDiaryActivity;
import com.frame.redmaple.main.activity.Me.RMMyOrderActivity;
import com.frame.redmaple.main.activity.Me.RMPurchaseActivity;
import com.frame.redmaple.main.activity.Me.RMQaActivity;
import com.frame.redmaple.main.activity.Me.RMUsinghelpActivity;
import com.frame.redmaple.main.adapter.RMMeAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.frame.redmaple.R.color.Hf10e50;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Me extends Fragment implements View.OnClickListener {
    private TextView tv_title;

    private LinearLayout ll_diary, ll_collection, ll_purchase, ll_myOrder, ll_calculator, ll_qa, ll_usinghelp, ll_aboutUs;

    private RecyclerView rv_me;
    List<String> directoryLabelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("我的");


        ll_diary = (LinearLayout) view.findViewById(R.id.ll_diary);
        ll_collection = (LinearLayout) view.findViewById(R.id.ll_collection);
        ll_purchase = (LinearLayout) view.findViewById(R.id.ll_purchase);
        ll_myOrder = (LinearLayout) view.findViewById(R.id.ll_myOrder);
        ll_calculator = (LinearLayout) view.findViewById(R.id.ll_calculator);
        ll_qa = (LinearLayout) view.findViewById(R.id.ll_qa);
        ll_usinghelp = (LinearLayout) view.findViewById(R.id.ll_usinghelp);
        ll_aboutUs = (LinearLayout) view.findViewById(R.id.ll_aboutUs);
        rv_me = (RecyclerView) view.findViewById(R.id.rv_me);
        RMMeAdapter rmMeAdapter = new RMMeAdapter(getContext(), directoryLabelList());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        rv_me.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL, R.drawable.item_divider));
        rv_me.setLayoutManager(gridLayoutManager);
        rv_me.setAdapter(rmMeAdapter);
        setListerner();
        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));


        return view;
    }

    private List<String> directoryLabelList() {


        directoryLabelList = new ArrayList<>();

        directoryLabelList.add("日记");
        directoryLabelList.add("我的收藏");
        directoryLabelList.add("购物车");
        directoryLabelList.add("我的订单");
        directoryLabelList.add("计算器");
        directoryLabelList.add("在线QA");
        directoryLabelList.add("使用帮助");
        directoryLabelList.add("关于我们");


        return directoryLabelList;
    }

    //设置监听器
    private void setListerner() {
        ll_diary.setOnClickListener(this);
        ll_collection.setOnClickListener(this);
        ll_purchase.setOnClickListener(this);
        ll_myOrder.setOnClickListener(this);
        ll_calculator.setOnClickListener(this);
        ll_qa.setOnClickListener(this);
        ll_usinghelp.setOnClickListener(this);
        ll_aboutUs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.ll_diary:
                intent.setClass(getContext(), RMDiaryActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_collection:
                intent.setClass(getContext(), RMCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_purchase:
                intent.setClass(getContext(), RMPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_myOrder:
                intent.setClass(getContext(), RMMyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_calculator:
                intent.setClass(getContext(), RMCalculatorActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_qa:
                intent.setClass(getContext(), RMQaActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_usinghelp:
                intent.setClass(getContext(), RMUsinghelpActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_aboutUs:
                intent.setClass(getContext(), RMAboutUsActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
