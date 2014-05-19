package com.oneplace.util;

public class Forward {
	private String path;
	private boolean forwarding = false;
	private Object data = null;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setForwarding(boolean forward) {
		this.forwarding = forward;
	}
	public boolean isForwarding(){
		return forwarding;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
