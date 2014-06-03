package com.util.kht;

import javax.servlet.http.HttpServletRequest;

public class RequestURIParser {
	public static String getAction(HttpServletRequest request){
		String URI = request.getRequestURI();
		int qMark = URI.length();
		int temp = URI.indexOf('?');
		if(temp != -1){
			qMark = temp;
		}
		return URI.substring(URI.lastIndexOf('/'), qMark);
	}
}
