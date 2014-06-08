package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.kht.RequestURIParser;

@WebServlet("*.go")
public class SenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SenderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		String uri = RequestURIParser.getAction(request);
		String where = (String)request.getParameter("where");
		switch(where){
		case "cafe":
			try {
				response.sendRedirect("../CafePlace"+uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}
