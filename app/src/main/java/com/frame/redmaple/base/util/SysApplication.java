package com.frame.redmaple.base.util;

import android.app.Activity;
import android.app.Application;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class SysApplication extends Application {
	private List<Activity> mList = new LinkedList<Activity>();
    private static SysApplication instance;

    private SysApplication() {
    }

    public synchronized static SysApplication getInstance() {
        if (null == instance) {
            instance = new SysApplication();
        }
        return instance;
    }

    /**
     * 添加当前Activity中栈中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    /**
     * 关闭隐藏的activity
     *
     * @param activity
     */
    public void finishHideActivity(Activity activity) {
        try {
            for (Activity ac : mList) {
                if (!ac.equals(activity)) {
                    ac.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 平铺方法
     *
     * @param view
     */
    public static void fixBackgroundRepeatY(View view) {
        Drawable bg = view.getBackground();
        if (bg != null) {
            if (bg instanceof BitmapDrawable) {
                BitmapDrawable bmp = (BitmapDrawable) bg;
                bmp.mutate(); // make sure that we aren't sharing state anymore
                bmp.setTileModeXY(null, Shader.TileMode.REPEAT);
            }
        }
    }
}