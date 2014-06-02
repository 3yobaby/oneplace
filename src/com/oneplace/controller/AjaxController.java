package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.util.Forward;
import com.oneplace.util.RequestURIParser;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OnePlaceController opController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
		if(getServletContext().getAttribute("opc") == null){
			opController = new OnePlaceController();
			getServletContext().setAttribute("opc", opController);
		}else{
			opController = (OnePlaceController) getServletContext().getAttribute("opc");
		}
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
		Forward forward = opController.executeAjax(command, request, response);
		if(forward == null)
			return;
		request.getRequestDispatcher(forward.getPath()).forward(request, response);;
	}
}
