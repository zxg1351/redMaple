package com.frame.redmaple.main.activity.Me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;

/**
 * Created by Administrator on 2017/9/26.
 */

public class RMMyOrderActivity extends CommonActivity {
    private TextView tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        initView();
        AbViewUtil.scaleContentView((LinearLayout) findViewById(R.id.rootLayout));
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的菜单");
    }
}
