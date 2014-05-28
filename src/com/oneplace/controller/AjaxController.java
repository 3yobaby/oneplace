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

import com.oneplace.util.Action;
import com.oneplace.util.Ajax;
import com.oneplace.util.RequestURIParser;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Object> commandMap;
	private Map<String, String> ajaxfile;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
        super();
    }
    
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	commandMap = new HashMap<String, Object>();
		loadProperties("com.oneplace.controller.properties/ajaxcommand");
		ajaxfile = new HashMap<String, String>();
		loadProperties2("com.oneplace.controller.properties/ajaxfilepath");
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
		Ajax instance = (Ajax) commandMap.get(command);
		if(instance == null){
			throw new ServletException("Ajax command not found");
		}
		instance.execute(command, request, response);
		RequestDispatcher rd = request.getRequestDispatcher(ajaxfile.get(command));
		rd.forward(request, response);
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
	
	private void loadProperties2(String path){
		ResourceBundle bundle = ResourceBundle.getBundle(path);
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String command = keys.nextElement();
			String ajaxfilepath = bundle.getString(command);
			ajaxfile.put(command, ajaxfilepath);
		}
	}
}
