package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.ajax.CafeAjax;
import com.oneplace.ajax.CafeSearchAjax;
import com.oneplace.ajax.MemberAjax;
import com.oneplace.application.OnePlaceApplication;
import com.util.kht.Ajax;
import com.util.kht.Application;
import com.util.kht.RequestURIParser;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Application app = (Application) getServletContext().getAttribute("OneApp");
		if(app == null){
			app = new OnePlaceApplication();
			getServletContext().setAttribute("OneApp", app);
		}
	}
    public AjaxController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = RequestURIParser.getAction(request);
		Ajax ajax = null;
		switch(command){
		case "/cafeSearch.ajax":
		case "/search_cafe_by_word.ajax":
			ajax = new CafeSearchAjax();
			break;
		case "/join_id_check.ajax":
		case "/login.ajax":
			ajax = new MemberAjax();
			break;
		case "/cafe_name_check.ajax":
			ajax = new CafeAjax();
			break;
		case "/id_pass_find.ajax":
			ajax = new MemberAjax();
			break;
		}
		if(ajax != null)
			ajax.execute(command, request, response);
	}
}
