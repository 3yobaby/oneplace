package com.oneplace.util;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

public class Oracle {
	private static ByteArrayBuffer temp;
	/*
	 * java타입읭 이름 : javaName
	 * oracle타입 이름 : java_name
	 */
	public static String getOracleName(String name){
		return replaceName(name);
	}
	public static String getOracleType(String type){
		String oracleType = null;
		if(type.equals("String")){
			oracleType = "varchar2";
		}else if(type.equals("int")){
			oracleType = "number";
		}else if(type.equals("Date")){
			oracleType = "date";
		}else if(type.equals("boolean")){
			oracleType = "boolean";
		}
		return oracleType;
	}
	private static String replaceName(String javaName){
		byte[] arr = javaName.getBytes();
		temp = new ByteArrayBuffer();
		// A~Z 65 ~ 90
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 65 && arr[i] <= 90){
				temp.write('_');
				temp.write(arr[i]+32);
			}else{
				temp.write(arr[i]);
			}
		}
		return temp.toString();
	}
}
