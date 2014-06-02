package com.oneplace.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Ajax {
	public Forward forward = new Forward();
	abstract public Forward execute(String command, HttpServletRequest request, HttpServletResponse response);
	public void setForwarding(boolean forwarding){
		forward.setForwarding(forwarding);
	}
	public void setPath(String path){
		forward.setPath(path);
	}
}
