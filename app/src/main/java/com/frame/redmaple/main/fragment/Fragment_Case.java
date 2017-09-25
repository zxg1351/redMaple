
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

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Case extends Fragment {

    private TextView tv_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_case, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("案例");
        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));
        return view;
    }
}
