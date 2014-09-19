package com.haimianbao.callback;

public interface HMBApiCallBack {
	public void OnSuccess(String result);

	public void OnFail(String result);

	public void OnError(String result);
}