package com.oneplace.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.util.*;
/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> commandMap;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = RequestURIParser.getAction(request); // command = "/action.bo"
		Action instance = (Action)commandMap.get(command);
		Forward forward = instance.execute(command, request, response);
		if(forward.isForwarding()){
			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
			rd.forward(request, response);
		}else{
			response.sendRedirect(forward.getPath());
		}
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		commandMap = new HashMap<String, Object>();
		loadProperties("com.dsboard.controller.properties/command");
	}
	
	private void loadProperties(String path){
		ResourceBundle bundle = ResourceBundle.getBundle(path);
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String command = keys.nextElement();
			String className = bundle.getString(command);
			try {
				Class<?> temp = Class.forName(className);
				Object instance = temp.newInstance();
				commandMap.put(command, instance);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
