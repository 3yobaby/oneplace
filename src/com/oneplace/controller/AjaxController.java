package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.ajax.CafeAjax;
import com.oneplace.ajax.MemberAjax;
import com.util.kht.Ajax;
import com.util.kht.RequestURIParser;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String command = RequestURIParser.getAction(request);
		Ajax ajax = null;
		switch (command) {
		// 회원정보 관련
		case "id_dup_check.ajax":
		case "forget_id.ajax":
		case "pass_check.ajax":
		case "login.ajax":
			ajax = new MemberAjax();
			break;
		// 카페 정보 관련
		case "get_all_cafe.ajax":
		case "get_my_join_cafe.ajax":
		case "get_my_cafe.ajax":
		case "get_all_organization.ajax":
		case "cafe_name_dup_check.ajax":
			ajax = new CafeAjax();
			break;
		}
		if (ajax != null)
			ajax.execute(command, request, response);
	}
}
