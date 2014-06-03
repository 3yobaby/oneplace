package com.oneplace.ajax;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.application.OnePlace;
import com.oneplace.dao.MemberDAO;
import com.util.kht.Ajax;

public class MemberAjax extends Ajax{
	private MemberDAO dao;
//	private OnePlace app;
	public MemberAjax(OnePlace app) {
//		this.app = app;
		dao = MemberDAO.getInstance();
	}
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/join_id_check.ajax":
			boolean result = dao.isDuplicatedId(request.getParameter("join_id"));
			try {
				ServletOutputStream os = response.getOutputStream();
				os.print(result);
				os.flush();
				os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}

}
