package com.frame.redmaple.main.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;
import com.frame.redmaple.base.util.Base64Util;
import com.frame.redmaple.base.wsdl.IConstants;

import java.util.Calendar;

/**
 * 登录
 */

@SuppressLint("HandlerLeak")
public class RMLoginActivity extends CommonActivity {
    public Context context = RMLoginActivity.this;
    private EditText Ed_userId, Ed_passWord;//账号，密码
    private String userId, phoneId, passWord, clientId;//账号，手机id，密码,个推id
    private CheckBox checkbox;//记住密码按钮
    public static RMLoginActivity RMLogin = null;
    private View Lyt_colseWxLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rmlogin);
        RMLogin = RMLoginActivity.this;
        activitylist.add(RMLoginActivity.this);
        initView();
        AbViewUtil.scaleContentView((LinearLayout) findViewById(R.id.rootLayout));
    }

    @Override
    protected void onStart() {
        super.onStart();
        setData();
    }

    private void initView() {
        Lyt_colseWxLogin = findViewById(R.id.lyt_colsewxlogin);// 判断隐藏微信登录按钮
        Ed_userId = (EditText) findViewById(R.id.ed_userId);//用户名
        Ed_passWord = (EditText) findViewById(R.id.ed_passWord);//密码
        checkbox = (CheckBox) findViewById(R.id.checkbox);//记住密码按钮
        ((TextView) findViewById(R.id.tv_login)).setOnClickListener(mClickListener);//登录按钮
        (findViewById(R.id.lyt_forget_wd)).setOnClickListener(mClickListener);//忘记密码按钮
        ((TextView) findViewById(R.id.tv_register)).setOnClickListener(mClickListener);//注册按钮
        ((ImageView) findViewById(R.id.iv_wxLogin)).setOnClickListener(mClickListener);//微信登录
    }

    private void setData() {
        SharedPreferences sharedPreferences = getSharedPreferences(IConstants.USER_INFO, Context.MODE_APPEND);
        Ed_userId.setText(sharedPreferences.getString("userId", null));
        if (sharedPreferences.getBoolean("checkbox", false)) {
            Ed_passWord.setText(sharedPreferences.getString("passWord", null));
            checkbox.setChecked(true);
        } else {
            Ed_passWord.setText("");
            checkbox.setChecked(false);
        }
    }

    public OnClickListener mClickListener = new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            switch (arg0.getId()) {
                case R.id.tv_login://登录按钮
                    if (isNetworkAvailable(context)) {
                        userId = Ed_userId.getText().toString().trim();
                        passWord = Base64Util.encode(Ed_passWord.getText().toString().trim());
                        if (isEmpty(userId)) {
                            ToastUtil3.showToast(context, "请输入用户名！");
                            return;
                        }
                        if (isEmpty(passWord)) {
                            ToastUtil3.showToast(context, "请输入密码！");
                            return;
                        }
                        Intent intent = new Intent(RMLoginActivity.this, RMHomeActivity.class);
                        startActivity(intent);
                        loading(context);
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                case R.id.lyt_forget_wd://忘记密码按钮
                    if (isNetworkAvailable(context)) {
                        Intent intent = new Intent(RMLoginActivity.this, RMForgetPwdActivity.class);
                        startActivity(intent);
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                case R.id.tv_register://注册按钮
                    if (isNetworkAvailable(context)) {
                        Intent intent = new Intent(RMLoginActivity.this, RMRegisterActivity.class);
                        startActivity(intent);
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                case R.id.iv_wxLogin://微信登录
                    if (isNetworkAvailable(context)) {
                        try {
                            long currentTime = Calendar.getInstance().getTimeInMillis();
                            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                                lastClickTime = currentTime;
                                loading(context);
                            }
                        } catch (Exception e) {
                            Log.i("防止多次点击！！！", e.getMessage());
                        }
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 如果本次登录账号与上次不同，则清空本地消息
     *
     * @author hgl
     * @Date 2017年4月10日17:33:55
     */
    public void clearMessage() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(IConstants.USER_INFO, Context.MODE_APPEND);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("alarm", false);
            editor.putBoolean("failure", false);
            editor.putBoolean("warning", false);
            editor.putString("recipient", "");// 收件人
            editor.putString("recipientPhone", "");// 收件人手机号
            editor.putString("recipientAddress", "");// 收件人地址
            editor.putBoolean("test", false);// 测试模式
            editor.commit();
        } catch (Exception e) {
            Log.i("本地消息清空", e.getMessage());
        }
    }

    public void colseDialog() {
        dismiss(context);
    }

    public void toasDialog(String str) {
        ToastUtil3.showToast(context, str);
    }
}
