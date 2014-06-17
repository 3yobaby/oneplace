package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.database.get.CafeDB;
import com.oneplace.database.get.CafeMemberDB;
import com.oneplace.database.get.CafeOrganizationDB;
import com.oneplace.database.get.CategoryDB;
import com.util.kht.RequestURIParser;

@WebServlet({ "*.cafe", "*.org" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uri = RequestURIParser.getAction(request);
		CafeDB db= new CafeDB();
		CategoryDB cadb = new CategoryDB();
		JSONObject cafe = db.getCafeByUri(uri);
		JSONArray categories = cadb.getAllCategoryArray(uri); 
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		if(member != null){
			if(Boolean.valueOf((String)cafe.get("is_organization"))){ // 기관이면
				CafeOrganizationDB codb = new CafeOrganizationDB();
				JSONArray cafes = codb.getCafeArray((String)cafe.get("uri")); // 소속 카페들
				session.setAttribute("cafes", cafes);
				codb.close();
			}
			CafeMemberDB cafemember = new CafeMemberDB();
			JSONObject cafeMember = cafemember.getObject((String)cafe.get("uri"), (String)member.get("id")); // 카페 회원타입을 가져오기 위해서
			cafemember.close();
			if(cafeMember == null)
				session.setAttribute("member_type", 0);
			else session.setAttribute("member_type", (int)cafeMember.get("member_type"));
			session.setAttribute("cafe", cafe);
			session.setAttribute("categories", categories);
			request.getRequestDispatcher("/cafe/index.jsp").forward(request, response);
		}else{
			session.setAttribute("member_type", 0);
			response.sendRedirect("./");
		}
	}
	
}
