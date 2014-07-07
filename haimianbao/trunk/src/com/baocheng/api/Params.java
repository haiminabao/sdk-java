package com.baocheng.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Params {
	private List<NameValuePair> params;

	/**
	 * 获取参数
	 */
	public List<NameValuePair> getParams() {
		return params;
	}

	/**
	 * 构造参数
	 */
	public Params() {
		params = new ArrayList<NameValuePair>();
		ArrayList<String> signatures = getSha1("dedc44b3ab0e8e341260c14169792aff");
		add("appkey", "c4ca4238a0b923820dcc509a6f75849b");
		add("nonce", signatures.get(0));
		add("timestamp", signatures.get(1));
		add("signature", signatures.get(2));
		add("version", signatures.get(3));
	}

	/**
	 * 添加参数
	 */
	public void add(String key, String value) {
		NameValuePair e = new BasicNameValuePair(key, value);
		params.add(e);
	}

	/**
	 * get参数拼起来
	 * 
	 * @return
	 */
	public String getUrl(String url) {
		int size = params.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			NameValuePair pair = params.get(i);
			if (i == 0) {
				sb.append("?");
			}
			sb.append(pair.getName());
			sb.append("=");
			sb.append(pair.getValue());
			if (i < size - 1) {
				sb.append("&");
			}
		}
		return url + sb.toString();
	}

	private ArrayList<String> getSha1(String appSecret) {
		ArrayList<String> lists = new ArrayList<String>();
		String signature = "";
		long nonce = Math.abs(new Random(System.currentTimeMillis()).nextInt());
		long timestamp = System.currentTimeMillis() / 1000;
		try {
			signature = SHA1(nonce + appSecret + timestamp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		lists.add(nonce + "");
		lists.add(timestamp + "");
		lists.add(signature);
		lists.add("1.0");
		return lists;
	}

	private String SHA1(String val) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("SHA-1");
		md5.update(val.getBytes());
		byte[] m = md5.digest();
		return bytesToHexString(m);
	}

	private String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
