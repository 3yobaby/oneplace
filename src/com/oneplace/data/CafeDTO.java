package com.oneplace.data;

import java.sql.Date;

import com.oneplace.util.DTO;

/*
 * 카페는 카페 관리자에 의해서 만들어진다
 * 1. pk
 * 2. 카페이름
 * 3. 만든 관리자 key
 * 4. 관련 기관 key
 * 5. 검색 허용
 * 7. 유효성(삭제)
 * 8. 생성날짜
 */
public class CafeDTO implements DTO{
	private int key;
	private String title;
	private int managerKey;
	private int organKey;
	private boolean search;
	private boolean isValid;
	private Date date;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getManagerKey() {
		return managerKey;
	}
	public void setManagerKey(int managerKey) {
		this.managerKey = managerKey;
	}
	public int getOrganKey() {
		return organKey;
	}
	public void setOrganKey(int organKey) {
		this.organKey = organKey;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
