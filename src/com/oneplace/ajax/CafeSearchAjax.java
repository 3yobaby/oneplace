package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.dao.CafeDAO;
import com.oneplace.util.Ajax;

public class CafeSearchAjax extends Ajax{
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		CafeDAO dao = new CafeDAO();
		switch(request.getParameter("select")){
		case "select_group_all":
			break;
		case "select_group_new":
			break;
		case "select_group_join":
			break;
		case "select_group_my":
			break;
		}
		request.getSession().setAttribute("search_result", dao.getSample());
	}
}
