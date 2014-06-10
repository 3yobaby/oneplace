package com.oneplace.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.util.kht.Ajax;
import com.util.kht.JSONObjectAble;
import com.util.kht.SampleData;

public class TestAjax extends Ajax{
    private SampleData data = SampleData.getInstance();
	@SuppressWarnings("unchecked")
	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<?, ?> map = null;
		switch(command){
		case "cafelist.data":
			map = data.getAllCafe();
			break;
		case "memberlist.data":
			map = data.getAllMember();
			break;
		case "board.data":
			getBoard(request, response);
			return;
		}
		JSONArray array = new JSONArray();
		for(Object obj : map.values()){
			array.add(((JSONObjectAble)obj).toJSONObject());
		}
		submit(array, response);
	}
	
	private String url = "";
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql = "";
	private String id = "scott";
	private String pass = "tiger";
	private void getBoard(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", id, pass);
			pstmt = conn.prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		
	}
	
	private void close(){
		if(pstmt !=null){
			try{pstmt.close();}catch(Exception ex){}
		}
		if(conn !=null){
			try{conn.close();}catch(Exception ex){}
		}
	}
}
