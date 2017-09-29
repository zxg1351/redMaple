package com.frame.redmaple.base;

import com.frame.redmaple.base.common.CommonBean;

import java.util.List;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/29.
 */

public class HomeBean extends CommonBean{


    List<String> mDatas;

    List<Integer> ipImages;


    public List<String> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    public List<Integer> getIpImages() {
        return ipImages;
    }

    public void setIpImages(List<Integer> ipImages) {
        this.ipImages = ipImages;
    }
}
