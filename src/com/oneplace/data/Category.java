package com.oneplace.data;

import com.oneplace.util.DTO;

/*
 * 카테고리는 카페 관리자에 의해서 생성되고 관리된다.
 * 해당 카페에서 케테고리 목록이 관리된다.
 * 1. pk
 * 2. 카테고리 타이틀
 * 3. 게시판 리스트
 * 4. 서브 카테고리에 해당하는가 isSubCategory
 * 5. cafe fk
 */
public class Category implements DTO{
	private int key;
	private int cafeKey;
	private String title;
	private boolean isSubCategory;
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
	
	public boolean isSubCategory() {
		return isSubCategory;
	}
	
	public void setSubCategory(boolean isSubCategory) {
		this.isSubCategory = isSubCategory;
	}

	public int getCafeKey() {
		return cafeKey;
	}
	public void setCafeKey(int cafeKey) {
		this.cafeKey = cafeKey;
	}
	
	
}
