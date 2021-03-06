
package com.frame.redmaple.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.util.RecycleViewDivider;
import com.frame.redmaple.main.activity.Case.CaseDetailsActivity;
import com.frame.redmaple.main.adapter.RMCaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class Fragment_Case extends Fragment {

    private TextView tv_title;
    private RecyclerView rv_case;
    private List<String> mDatas;
    private RMCaseAdapter caseAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_case, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("案例");
        initData();
        caseAdapter = new RMCaseAdapter(getContext(), mDatas);
        rv_case = (RecyclerView) view.findViewById(R.id.rv_case);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_case.setLayoutManager(linearLayoutManager);
        rv_case.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        rv_case.setAdapter(caseAdapter);
        caseAdapter.setmOnItemClickLitener(new RMCaseAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), position + " click",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), CaseDetailsActivity.class);
                intent.putExtra("positionName", position + " click");
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });


        AbViewUtil.scaleContentView((LinearLayout) view.findViewById(R.id.rootLayout));


        return view;
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i + "案例");
        }
    }

}
