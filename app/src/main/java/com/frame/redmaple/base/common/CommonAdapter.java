package com.frame.redmaple.base.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.BaseAdapter;

/**
 * adapter共同类
 * @author hgl
 * @Date 2017年3月27日09:49:55
 */
@SuppressWarnings("deprecation")
public abstract class CommonAdapter extends BaseAdapter {
	public static final int MIN_CLICK_DELAY_TIME = 1000;
	public long lastClickTime = 0;
	/**
	 * 判断手机网络是否联通
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm == null) {
		} else {
			// 如果仅仅是用来判断网络连接
			// 则可以使用 cm.getActiveNetworkInfo().isAvailable();
			NetworkInfo[] info = cm.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
//	/**
//	 * 防止重复点击方法
//	 *
//	 * @return
//	 */
//	public static boolean isFastDoubleClick() {
//		long time = System.currentTimeMillis();
//		long timeD = time - lastClickTime;
//		if (0 < timeD && timeD < 1000) {
//			return false;
//		}
//		lastClickTime = time;
//		return true;
//	}
}
