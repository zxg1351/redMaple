package com.frame.redmaple.main.fragment;

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
        switch (view.getId()) {

            case R.id.ll_diary:

//                CommonActivity.ToastUtil3.showToast(this,"跳转到日记页面");
                break;
            case R.id.ll_collection:
                break;
            case R.id.ll_purchase:
                break;
            case R.id.ll_myOrder:
                break;
            case R.id.ll_calculator:
                break;
            case R.id.ll_qa:
                break;
            case R.id.ll_usinghelp:
                break;
            case R.id.ll_aboutUs:
                break;
            default:
                break;


        }
    }
}
