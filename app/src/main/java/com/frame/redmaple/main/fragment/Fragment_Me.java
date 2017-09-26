package com.frame.redmaple.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;
import com.frame.redmaple.main.activity.Me.RMAboutUsActivity;
import com.frame.redmaple.main.activity.Me.RMCalculatorActivity;
import com.frame.redmaple.main.activity.Me.RMCollectionActivity;
import com.frame.redmaple.main.activity.Me.RMDiaryActivity;
import com.frame.redmaple.main.activity.Me.RMMyOrderActivity;
import com.frame.redmaple.main.activity.Me.RMPurchaseActivity;
import com.frame.redmaple.main.activity.Me.RMQaActivity;
import com.frame.redmaple.main.activity.Me.RMUsinghelpActivity;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Me extends Fragment implements View.OnClickListener {
    private TextView tv_title;

    private LinearLayout ll_diary, ll_collection, ll_purchase, ll_myOrder, ll_calculator, ll_qa, ll_usinghelp, ll_aboutUs;

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

        setListerner();
        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));


        return view;
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
