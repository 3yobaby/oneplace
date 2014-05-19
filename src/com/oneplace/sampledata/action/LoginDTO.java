package com.oneplace.sampledata.action;

import java.sql.Date;

import com.oneplace.util.DTO;

/*
 * 로그인 정보에 필요한 정보
 * 로그인 요청시 Member를 생성하고
 * 데이터베이스로 id와 pass를 검색해 isValid를 돌려받아서 Action으로 돌려준다
 * 최근 접속 시간
 */
public class LoginDTO implements DTO{
	private int key;
	private String id;
	private String pass;
	private Date lastLogin;
	private boolean isValid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public LoginDTO getSample(){
		LoginDTO dto = new LoginDTO();
		dto.setId("sampleId");
		dto.setPass("1234");
		dto.setValid(true);
		return dto;
	}
}
