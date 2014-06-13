package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.database.get.CafeDB;
import com.oneplace.database.get.CategoryDB;
import com.util.kht.RequestURIParser;

@WebServlet({ "*.cafe", "*.org" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = RequestURIParser.getAction(request);
		CafeDB db= new CafeDB();
		CategoryDB cadb = new CategoryDB();
		JSONObject cafe = db.getCafeByUri(uri);
		JSONArray categories = cadb.getAllCategoryArray(uri); 
		request.getSession().setAttribute("cafe", cafe);
		request.getSession().setAttribute("categories", categories);
		request.getRequestDispatcher("/cafe/index.jsp").forward(request, response);
	}
}
