package com.util.kht;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action{
	protected Application app;
	public Forward forward = new Forward();
	abstract public Forward execute(String command, HttpServletRequest request, HttpServletResponse response);
	public Action(Application app) {
		this.app = app;
	}
	public void setForwarding(boolean forwarding){
		forward.setForwarding(forwarding);
	}
	public void setPath(String path){
		forward.setPath(path);
	}
}
