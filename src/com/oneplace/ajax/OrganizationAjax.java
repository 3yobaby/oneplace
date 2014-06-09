package com.oneplace.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.oneplace.dao.OrganizationDAO;
import com.oneplace.data.Organization;
import com.util.kht.Ajax;

@SuppressWarnings("unchecked")
public class OrganizationAjax extends Ajax{

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "org_search.ajax":
			search(request, response);
			break;
		}
	}

	
	private void search(HttpServletRequest request, HttpServletResponse response) {
		OrganizationDAO dao = new OrganizationDAO();
		ArrayList<Organization> list = dao.getOrganizationList();
		JSONArray array = new JSONArray();
		for (Organization json : list) {
			array.add(json.toJSONObject());
		}
		submit(array, response);
	}


}
