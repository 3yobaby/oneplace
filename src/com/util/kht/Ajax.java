package com.util.kht;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public abstract class Ajax {
	public abstract void execute(String command, HttpServletRequest request, HttpServletResponse response);
	
	protected void submit(boolean b, HttpServletResponse response){
		JSONObject obj = new JSONObject();
		obj.put("result", b);
		submit(obj.toString(), response);
	}
	
	protected void submit(JSONObjectAble json, HttpServletResponse response){
		submit(json.toString(), response);
	}
	
	protected void submit(JSONArray json, HttpServletResponse response){
		submit(json.toString(), response);
	}
	
	protected void submit(JSONObject json, HttpServletResponse response){
		submit(json.toString(), response);
	}
	
	protected void submit(String command, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.append(command);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
