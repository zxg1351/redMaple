package com.frame.redmaple.main.activity.Case;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;

/**
 * 案例详细页面
 * Created by Administrator on 2017/10/9.
 */

public class CaseDetailsActivity extends CommonActivity {

    private TextView tv_casePosition, tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casedetails);
        initData();
        Intent intent = getIntent();

        tv_casePosition.setText(intent.getStringExtra("positionName"));
        tv_title.setText("案例详情");
        AbViewUtil.scaleContentView((LinearLayout) findViewById(R.id.rootLayout));

    }

    private void initData() {
        tv_casePosition = (TextView) findViewById(R.id.tv_casePosition);
        tv_title = findViewById(R.id.tv_title);
    }

}
