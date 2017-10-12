package com.frame.redmaple.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;
import com.frame.redmaple.main.fragment.Fragment_Case;
import com.frame.redmaple.main.fragment.Fragment_Home;
import com.frame.redmaple.main.fragment.Fragment_Me;

/**
 * Created by Administrator on 2017/9/25.
 */

public class RMHomeActivity extends AppCompatActivity {
    //    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragmentTransaction transactionCase;
    private FragmentTransaction transactionHome;
    private FragmentTransaction transactionMe;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_test);
//        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {
            Fragment_Home fragment_home = new Fragment_Home();
            transaction.add(R.id.ll_fragment, fragment_home);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        initView();
//        findViewById(R.id.toolbar);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
//        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.rootLayout);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()) {
//
//                    case R.id.item_one:
//                        CommonActivity.ToastUtil3.showToast(getBaseContext(), "测试退出成功");
//
//                        break;
//                }
//                item.setChecked(true);//点击了把它设为选中状态
//                mDrawerLayout.closeDrawers();//关闭抽屉
//                return true;
//            }
//        });

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


    private void initView() {
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
//        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
//        toolbar_title.setText("首页");

        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.rootLayout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mToolbar.setNavigationIcon(R.mipmap.icon_skid);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_one:
                        CommonActivity.ToastUtil3.showToast(RMHomeActivity.this, "点击退出成功");

                        break;

                }
                menuItem.setChecked(true);//点击了把它设为选中状态
                mDrawerLayout.closeDrawers();//关闭抽屉
                return true;
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

        transactionHome = fragmentManager.beginTransaction();
        Fragment_Home fragment_home = new Fragment_Home();
        transactionHome.replace(R.id.ll_fragment, fragment_home);
        transactionHome.addToBackStack(null);
        transactionHome.commit();

    }


}
