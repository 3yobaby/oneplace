package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.ajax.TestAjax;
import com.util.kht.RequestURIParser;
import com.util.kht.SampleData;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("*.data")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = RequestURIParser.getAction(request);		
		new TestAjax().execute(command, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
