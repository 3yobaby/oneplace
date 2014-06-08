package com.oneplace.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.oneplace.dao.CafeDAO;
import com.oneplace.data.Cafe;
import com.oneplace.data.Member;
import com.util.kht.Ajax;
import com.util.kht.DAO;

public class CafeSearchAjax extends Ajax{
	public CafeSearchAjax() {}

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/cafeSearch.ajax":
			search(request, response);
			break;
		case "/search_cafe_by_word.ajax":
			searchCafeByWord(request,response);
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void search(HttpServletRequest request,
			HttpServletResponse response){
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		DAO dao;
		Member member;
		JSONArray array = new JSONArray();
		switch(request.getParameter("select")){
		case "select_group_all":
			dao = new CafeDAO();
			list = ((CafeDAO)dao).getAllCafeList();
			break;
		case "select_group_new":
			dao = new CafeDAO();
			list = ((CafeDAO)dao).getNewCafeList(10); // cafe numbers
			break;
		case "select_group_join":
			member = (Member) request.getSession().getAttribute("member");
			if(member == null){
				break;
			}
			dao = new CafeDAO();
			list = ((CafeDAO) dao).getCafeList(member);
			break;
		case "select_group_my":
			member = (Member) request.getSession().getAttribute("member");
			if(member == null){
				break;
			}
			dao = new CafeDAO();
			list = ((CafeDAO) dao).getMyCafeList(member);
			break;
		}
		
		for (Cafe cafe : list) {
			array.add(cafe.getJson());
		}
		submit(array.toString(), response);
	}
	
	@SuppressWarnings("unchecked")
	private void searchCafeByWord(HttpServletRequest request,
			HttpServletResponse response) {
		String word = request.getParameter("word");
		CafeDAO dao = new CafeDAO();
		ArrayList<Cafe> list = dao.getCafeBySearchWord(word);
		JSONArray array = new JSONArray();
		for (Cafe cafe : list) {
			array.add(cafe.getJson());
		}
		submit(array.toString(), response);
	}

}
