package com.oneplace.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Ajax {
	abstract public void execute(String command, HttpServletRequest request, HttpServletResponse response);
}
