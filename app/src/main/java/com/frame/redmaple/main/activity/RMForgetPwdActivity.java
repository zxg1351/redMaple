package com.frame.redmaple.main.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonActivity;
import com.frame.redmaple.base.util.Base64Util;

/**
 * Created by Administrator on 2017/9/20.
 */

public class RMForgetPwdActivity extends CommonActivity {

    private int recLen = COUNT_DOWN; // 倒计时
    private Context context = RMForgetPwdActivity.this;
    private String userId, phoneId, password, code;//账号,手机设备码,密码,验证码
    private EditText Ed_userId, Ed_passWord, Ed_code;
    private TextView Tv_submit, Tv_send_code;//修改按钮,发送验证码按钮
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rmforgetpwd);
        phoneId = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();
        initView();
        activitylist.add(RMForgetPwdActivity.this);
        AbViewUtil.scaleContentView((LinearLayout) findViewById(R.id.rootLayout));
    }

    private void initView() {
        Ed_userId = (EditText) findViewById(R.id.ed_userId);
        Ed_passWord = (EditText) findViewById(R.id.ed_passWord);
        Ed_code = (EditText) findViewById(R.id.ed_code);
        Tv_submit = (TextView) findViewById(R.id.tv_submit);// 修改按钮
        Tv_submit.setOnClickListener(mClickListener);
        Tv_send_code = (TextView) findViewById(R.id.tv_send_code);// 发送验证码按钮
        Tv_send_code.setOnClickListener(mClickListener);
    }

    public View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            switch (arg0.getId()) {
                case R.id.tv_submit:// 修改按钮
                    if (isNetworkAvailable(context)) {
                        userId = Ed_userId.getText().toString().trim();//账号
                        password = Base64Util.encode(Ed_passWord.getText().toString().trim());//密码
                        code = Ed_code.getText().toString().trim();//验证码
                        if (isEmpty(userId)) {
                            ToastUtil3.showToast(context, "请输入用户名！");
                            return;
                        }
                        if (isEmpty(password)) {
                            ToastUtil3.showToast(context, "请输入密码！");
                            return;
                        }
                        if (isEmpty(code)) {
                            ToastUtil3.showToast(context, "请输入验证码！");
                            return;
                        }
                        status = R.id.tv_submit;
                        loading(context);
//                        new Thread(runnable).start();
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                case R.id.tv_send_code:// 发送验证码按钮
                    if (isNetworkAvailable(context)) {
                        userId = Ed_userId.getText().toString().trim();//账号
                        if (isEmpty(userId)) {
                            ToastUtil3.showToast(context, "请输入用户名！");
                            return;
                        }
                        status = R.id.tv_send_code;
                        loading(context);
//                        new Thread(runnable).start();
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
     * 倒计时线程
     */
    final Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    recLen--;
                    Tv_send_code.setText(recLen + "秒");

                    if (recLen > 0) {
                        Tv_send_code.setBackgroundResource(R.drawable.bac_kd002_02);
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);
                    } else {
                        Tv_send_code.setBackgroundResource(R.drawable.bac_kd002_01);
                        Tv_send_code.setClickable(true);
                        Tv_send_code.setText("重新发送");
                        recLen = COUNT_DOWN;
                    }
            }

            super.handleMessage(msg);
        }
    };
}
