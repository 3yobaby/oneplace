package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.util.*;

public class Login extends Action{
	
	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		if(command.equals("/Login.do")){
			setForwarding(true);
			setPath("/WEB-INF/main.jsp");
		}
		return forward;
	}
	
}
