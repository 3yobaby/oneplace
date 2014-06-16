package com.oneplace.temp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.oneplace.database.get.BoardDB;
import com.oneplace.database.get.CafeDB;
import com.oneplace.database.get.CafeMemberDB;
import com.oneplace.database.get.CategoryDB;
import com.oneplace.database.get.MemberDB;
import com.util.kht.Ajax;

public class TestAjax extends Ajax{
	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = null;
		switch(command){
		case "cafelist.data":
			CafeDB cafedb = new CafeDB();
			array = cafedb.getAllCafeArray();
			cafedb.close();
			break;
		case "memberlist.data":
			MemberDB memberdb = new MemberDB();
			array = memberdb.getAllMemberArray();
			memberdb.close();
			break;
		case "boardlist.data":
			BoardDB boarddb = new BoardDB();
			array = boarddb.getAllBoardArray();
			boarddb.close();
			break;
		case "categorylist.data":
			CategoryDB categorydb = new CategoryDB();
			array = categorydb.getAllCategoryArray();
			categorydb.close();
			break;
		case "memberjoinedcafelist.data":
			CafeMemberDB db = new CafeMemberDB();
			array = db.getAll();
			db.close();
			break;
		}
		if(array == null)
			submit(new JSONArray(), response);
		else submit(array, response);
	}
	
}
