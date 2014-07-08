package com.baocheng.callback;

public interface BCApiCallBack {
	public void OnSuccess(String result);

	public void OnFail(String result);

	public void OnError(String result);
}