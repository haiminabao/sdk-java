package com.baocheng.net;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.baocheng.callback.BCApiCallBack;

public class BCNet {
	private String url;
	private static BCNet net;

	public static BCNet getInstance() {
		if (net == null) {
			net = new BCNet();
		}
		return net;
	}

	/**
	 * get请求
	 * 
	 * @param url
	 * @param addParams
	 *            添加参数
	 * @param timeout
	 *            超时时间
	 * @param callBack
	 *            结果回调
	 */
	public void get(final String url1, final AddParams addParams, final int timeout, final BCApiCallBack callBack) {
		new Thread(url1) {
			public void run() {
				url = addParams.getUrl(url1);
				System.out.println(url);
				HttpGet get = new HttpGet(url);
				try {
					HttpResponse response = new DefaultHttpClient(setConnParams(timeout)).execute(get);
					int code = response.getStatusLine().getStatusCode();
					if (code == 200) {
						callBack.OnSuccess(EntityUtils.toString(response.getEntity()));
					} else {
						callBack.OnFail(code + "");
					}
				} catch (ClientProtocolException e) {
					callBack.OnFail(e.getMessage());
				} catch (IOException e) {
					callBack.OnFail(e.getMessage());
				}
			};
		}.start();
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param addParams
	 *            添加参数
	 * @param timeout
	 *            超时时间
	 * @param callBack
	 *            结果回调
	 */
	public void post(final String url2, final AddParams addParams, final int timeout, final BCApiCallBack callBack) {
		new Thread(url2) {
			public void run() {
				HttpPost post = new HttpPost(url2);
				url = addParams.getUrl(url2);
				HttpEntity entity;
				try {
					entity = new UrlEncodedFormEntity(addParams.getParams());
					post.setEntity(entity);
					HttpResponse response = new DefaultHttpClient(setConnParams(timeout)).execute(post);
					int code = response.getStatusLine().getStatusCode();
					if (code == 200) {
						callBack.OnSuccess(EntityUtils.toString(response.getEntity()));
					} else {
						callBack.OnFail(code + "");
					}
				} catch (ClientProtocolException e) {
					callBack.OnFail(e.getMessage());
				} catch (IOException e) {
					callBack.OnFail(e.getMessage());
				}
			};
		}.start();
	}
	
	/**
	 * 带头的post请求
	 * 
	 * @param url
	 * @param addParams
	 *            添加参数
	 * @param timeout
	 *            超时时间
	 * @param callBack
	 *            结果回调
	 */
	public void post(final String url2, final AddParams addParams, final int timeout, final BCApiCallBack callBack,final String header,final String json) {
		new Thread(url2) {
			public void run() {
				url = addParams.getUrl(url2);
				System.out.println(url);
				HttpPost post = new HttpPost(url);
				post.addHeader("Content Type", header);
				HttpEntity entity;
				try {
					System.out.println(json);
					entity = new StringEntity(json);
					post.setEntity(entity);
					HttpResponse response = new DefaultHttpClient(setConnParams(timeout)).execute(post);
					int code = response.getStatusLine().getStatusCode();
					if (code == 200) {
						callBack.OnSuccess(EntityUtils.toString(response.getEntity()));
					} else {
						callBack.OnFail(code + "");
					}
				} catch (ClientProtocolException e) {
					callBack.OnFail(e.getMessage());
				} catch (IOException e) {
					callBack.OnFail(e.getMessage());
				}
			};
		}.start();
	}

	/**
	 * 设置连接参数
	 * 
	 * @param timeout
	 */
	private static HttpParams setConnParams(int timeout) {
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, timeout);
		HttpConnectionParams.setSoTimeout(params, timeout);
		HttpConnectionParams.setSocketBufferSize(params, 8192);
		return params;
	}
}
