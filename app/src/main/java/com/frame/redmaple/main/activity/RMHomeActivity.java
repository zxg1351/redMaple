package com.frame.redmaple.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.TextView;

import com.frame.redmaple.R;
import com.frame.redmaple.main.fragment.Fragment_Case;
import com.frame.redmaple.main.fragment.Fragment_Home;
import com.frame.redmaple.main.fragment.Fragment_Me;

/**
 * Created by Administrator on 2017/9/25.
 */

public class RMHomeActivity extends FragmentActivity {
    //    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragmentTransaction transactionCase;

    private FragmentTransaction transactionMe;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);


        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {
            Fragment_Home fragment_home = new Fragment_Home();
            transaction.replace(R.id.ll_fragment, fragment_home);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.navigation_home:
//                        mTextMessage.setText(R.string.title_home);
                        toHome();
                        return true;
                    case R.id.navigation_dashboard:
//                        mTextMessage.setText(R.string.title_dashboard);
                        toCase();
                        return true;
                    case R.id.navigation_notifications:
//                        mTextMessage.setText(R.string.title_notifications);
                        toMe();
                        return true;
                }
                return false;
            }
        });


    }

    /**
     * 我的
     */
    private void toMe() {

        transactionMe = fragmentManager.beginTransaction();
        Fragment_Me fragment_me = new Fragment_Me();
        transactionMe.replace(R.id.ll_fragment, fragment_me);
        transactionMe.addToBackStack(null);
        transactionMe.commit();


    }

    //案例发现
    private void toCase() {

        transactionCase = fragmentManager.beginTransaction();
        Fragment_Case fragment_Case = new Fragment_Case();
        transactionCase.replace(R.id.ll_fragment, fragment_Case);
        transactionCase.addToBackStack(null);
        transactionCase.commit();
    }

    //主页
    private void toHome() {

        transaction = fragmentManager.beginTransaction();
        Fragment_Home fragment_home = new Fragment_Home();
        transaction.replace(R.id.ll_fragment, fragment_home);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}
