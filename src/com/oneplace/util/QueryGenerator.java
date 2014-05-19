package com.oneplace.util;

import java.lang.reflect.Field;


public class QueryGenerator {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		new QueryGenerator().getQuery((Class<DTO>)Class.forName("com.dsboard.sampledata.MemberDTO"));
	}
	
	public String getQuery(Class<DTO> dto) {
		TypeName[] values = getTypeName(dto);
		return null;
	}
	
	private TypeName[] getTypeName(Class<DTO> dto){
		Field[] fields = dto.getDeclaredFields();
		int length = fields.length;
		TypeName[] array = new TypeName[length];
		for(int i=0; i<length; i++){
			array[i] = new TypeName();
			String type = fields[i].getGenericType().toString();
			String name = fields[i].getName();
			try{
				// get Type
				type = type.substring(type.lastIndexOf('.')+1);
				array[i].type = Oracle.getOracleType(type);
				array[i].name = Oracle.getOracleName(name);
				
				System.out.println(array[i].toString());
			}catch(Exception e){}
		}
		return array;
	}
	
	private class TypeName{
		public String type;
		public String name;
		
		public String toString(){
			return type + " " + name;
		}
	}

}
