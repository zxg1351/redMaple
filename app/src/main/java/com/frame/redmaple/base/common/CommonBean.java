package com.frame.redmaple.base.common;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/18.
 */
@Data
public class CommonBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String stateCode;// 接口返回状态
    private String stateMsg;// 接口返回消息
    private String phoneId;// 手机唯一标识
    private String userId;// 登录账号


}
