package com.frame.redmaple.base.util;

import android.util.Log;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Util {
	private static final String charset = "utf-8";

	/**
	 * 解密
	 * 
	 * @param data
	 * @return
	 * @author jqlin
	 */
	public static String decode(String data) {
		try {
			if (null == data) {
				return null;
			}

			return new String(Base64.decodeBase64(data.getBytes(charset)), charset);
		} catch (UnsupportedEncodingException e) {
			Log.i("字符串：%s，解密异常", e.getMessage());
		}

		return null;
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 * @author jqlin
	 */
	public static String encode(String data) {
		try {
			if (null == data) {
				return null;
			}
			return new String(Base64.encodeBase64(data.getBytes(charset)), charset);
		} catch (UnsupportedEncodingException e) {
			Log.i("字符串：%s，加密异常", e.getMessage());
		}
		return null;
	}

}