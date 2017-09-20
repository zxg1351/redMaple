package com.frame.redmaple.main.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.util.SysApplication;
import com.frame.redmaple.main.activity.RMLoginActivity;


import java.util.ArrayList;

/**
 * 第一次运行的引导页代码
 */
public class WelcomeActivity extends Activity implements OnPageChangeListener, OnClickListener {
    private Context context;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private Button startButton;
    private Button jumpButton;
    private LinearLayout indicatorLayout;
    private ArrayList<View> views;
    private ImageView[] indicators = null;
    private int[] images;
    private float mScale;// 控制低下点距离

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SysApplication.getInstance().addActivity(this);
        context = this;
        // 创建桌面快捷方式
        new CreateShut(this);
        // 设置引导图片
        // 仅需在这设置图片 指示器和page自动添加
        images = new int[]{R.mipmap.ic_boot_page1, R.mipmap.ic_boot_page3, R.mipmap.ic_boot_page2};
        initView();
        AbViewUtil.scaleContentView((RelativeLayout) findViewById(R.id.rootLayout));
    }

    // 初始化视图
    @SuppressWarnings("deprecation")
    private void initView() {
        // 实例化视图控件
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        jumpButton = (Button) findViewById(R.id.jumpButton);
        jumpButton.setOnClickListener(this);
        startButton = (Button) findViewById(R.id.start_Button);
        startButton.setOnClickListener(this);
        indicatorLayout = (LinearLayout) findViewById(R.id.indicator);
        views = new ArrayList<View>();
        indicators = new ImageView[images.length]; // 定义指示器数组大小
        for (int i = 0; i < images.length; i++) {
            // 循环加入图片
            ImageView imageView = new ImageView(context);
            mScale = context.getResources().getDisplayMetrics().density;// //控制低下点距离
            int imageParams = (int) (mScale * 10 + 0.5f);// XP与DP转换，适应应不同分辨率
            imageView.setBackgroundResource(images[i]);
            views.add(imageView);
            // 循环加入指示器
            indicators[i] = new ImageView(context);
            indicators[i].setBackgroundResource(R.mipmap.dot_blur1);
            if (i == 0) {
                indicators[i].setBackgroundResource(R.mipmap.dot_blur2);
            }
            LayoutParams params = new LayoutParams(imageParams, imageParams);// 控制低下点距离
            params.leftMargin = 15;// 控制低下点距离
            indicators[i].setLayoutParams(params);// 控制低下点距离
            indicatorLayout.addView(indicators[i]);
        }
        pagerAdapter = new BasePagerAdapter(views);
        viewPager.setAdapter(pagerAdapter); // 设置适配器
        viewPager.setOnPageChangeListener(this);
    }

    // 按钮的点击事件
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_Button) {
            SharedPreferences shared = getSharedPreferences("config", MODE_PRIVATE);
            Editor editor = shared.edit();
            editor.putBoolean("First", false);
            editor.commit();
            startActivity(new Intent(WelcomeActivity.this, RMLoginActivity.class));
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            this.finish();
        }
        if (v.getId() == R.id.jumpButton) {
            SharedPreferences shared = getSharedPreferences("config", MODE_PRIVATE);
            Editor editor = shared.edit();
            editor.putBoolean("First", false);
            editor.commit();
            startActivity(new Intent(WelcomeActivity.this, RMLoginActivity.class));
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            this.finish();
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    // 监听viewpage
    @Override
    public void onPageSelected(int arg0) {
        // 显示最后一个图片时显示按钮
        if (arg0 == indicators.length - 1) {
            startButton.setVisibility(View.VISIBLE);
        } else {
            startButton.setVisibility(View.INVISIBLE);
        }
        // 更改指示器图片
        for (int i = 0; i < indicators.length; i++) {
            indicators[arg0].setBackgroundResource(R.mipmap.dot_blur2);
            if (arg0 != i) {
                indicators[i].setBackgroundResource(R.mipmap.dot_blur1);
            }
        }
    }
}
