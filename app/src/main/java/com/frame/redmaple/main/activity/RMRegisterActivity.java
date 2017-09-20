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

public class RMRegisterActivity extends CommonActivity {


    private int recLen = COUNT_DOWN; // 倒计时
    private Context context = RMRegisterActivity.this;
    //    private KDRegisterBean kdRegisterBean;
//    private KDRegisterCodeBean kdRegisterCodeBean;
    private String userId, phoneId, mobile, password, code;//账号, 手机设备码, 手机号, 密码, 验证码;
    private EditText Ed_userId, Ed_mobile, Ed_passWord, Ed_code;
    private TextView Tv_submit, Tv_send_code;//注册按钮,发送验证按钮
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rmregister);
//        phoneId = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();
        initView();
        AbViewUtil.scaleContentView((LinearLayout) findViewById(R.id.rootLayout));
    }

    private void initView() {
        Ed_userId = (EditText) findViewById(R.id.ed_userId);//账号
        Ed_mobile = (EditText) findViewById(R.id.ed_mobile);//手机号
        Ed_passWord = (EditText) findViewById(R.id.ed_passWord);//密码
        Ed_code = (EditText) findViewById(R.id.ed_code);//验证码
        Tv_submit = (TextView) findViewById(R.id.tv_submit);//注册按钮
        Tv_submit.setOnClickListener(mClickListener);
        Tv_send_code = (TextView) findViewById(R.id.tv_send_code);// 发送验证码按钮
        Tv_send_code.setOnClickListener(mClickListener);
    }

    public View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            switch (arg0.getId()) {
                case R.id.tv_submit:
                    if (isNetworkAvailable(context)) {
                        userId = Ed_userId.getText().toString().trim();//账号
                        mobile = Ed_mobile.getText().toString().trim();//手机号
                        password = Base64Util.encode(Ed_passWord.getText().toString().trim());//密码
                        code = Ed_code.getText().toString().trim();//验证码
                        if (isEmpty(userId)) {
                            ToastUtil3.showToast(context, "请输入用户名！");
                            return;
                        }
                        if (userId.length() < 6) {
                            ToastUtil3.showToast(context, "用户名必须大于6位！");
                            return;
                        }
                        if (isEmpty(mobile)) {
                            ToastUtil3.showToast(context, "请输入手机号！");
                            return;
                        }
                        if (!isMobile(mobile)) {
                            ToastUtil3.showToast(context, "请输入正确的手机号！");
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
                        new Thread(runnable).start();
                    } else {
                        ToastUtil3.showToast(context, getString(R.string.net_off));
                    }
                    break;
                case R.id.tv_send_code:
                    if (isNetworkAvailable(context)) {
                        mobile = Ed_mobile.getText().toString().trim();//手机号
                        if (isEmpty(mobile)) {
                            ToastUtil3.showToast(context, "请输入手机号！");
                            return;
                        }
                        if (!isMobile(mobile)) {
                            ToastUtil3.showToast(context, "请输入正确的手机号！");
                            return;
                        }
                        status = R.id.tv_send_code;
                        loading(context);
                        new Thread(runnable).start();
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

    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            Message message = new Message();
            switch (status) {
                case R.id.tv_submit://提交按钮
                    try {
//                        kdRegisterBean = wsdl.register(userId, phoneId, mobile, password, code);
                    } catch (Exception e) {
//                        Log.i(IConstants.REGISTER, e.getMessage());
                    }
                    break;
                case R.id.tv_send_code:
                    try {
//                        kdRegisterCodeBean = wsdl.sendCode04(mobile, phoneId);
                    } catch (Exception e) {
//                        Log.i(IConstants.SENDCODE04, e.getMessage());
                    }
                    break;
                default:
                    break;
            }
//            loadingmhandler.sendMessage(message);
        }
    };

//    Handler loadingmhandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            try {
//                dismiss(context);
//                switch (status) {
//                    case R.id.tv_submit://提交按钮
//                        if (IConstants.STR_ZERO.equals(kdRegisterBean.getStateCode())) {
//                            ToastUtil3.showToast(context, "注册成功！");
//                            finish();
//                        }else{
//                            ToastUtil3.showToast(context, kdRegisterBean.getStateMsg());
//                        }
//                        break;
//                    case R.id.tv_send_code:
//                        if (IConstants.STR_ZERO.equals(kdRegisterCodeBean.getStateCode())) {
//                            ToastUtil3.showToast(context, "发送成功！");
//                            Tv_send_code.setClickable(false); // 按钮不可用
//                            Message message = handler.obtainMessage(1); // 倒计时开始
//                            handler.sendMessageDelayed(message, 1000); // 间隔1秒钟
//                        }else{
//                            ToastUtil3.showToast(context, kdRegisterBean.getStateMsg());
//                        }
//                        break;
//                    default:
//                        break;
//                }
//            } catch (Exception ex) {
//                Log.i(IConstants.REGISTER, ex.getMessage());
//            }
//        }
//    };
}
