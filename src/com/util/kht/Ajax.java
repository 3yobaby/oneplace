package com.util.kht;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Ajax {
	protected Application app;
	abstract public void execute(String command, HttpServletRequest request, HttpServletResponse response);
	public Ajax(Application app) {
		this.app = app;
	}
}
