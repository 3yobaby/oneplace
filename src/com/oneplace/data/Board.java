package com.oneplace.data;

import java.sql.Date;

import com.util.kht.DTO;

/*
 * 게시글
 * 
 * 1. pk
 * 2. 제목
 * 3. 작성자(fk, member) 
 * 4. 컨텐츠 - 내용 : 태그로 이루어진 문자열, 이미지 등은 서버의 디렉토리에 보관되어있도록 한다.
 * 5. 공개타입 3가지- 0. 모두공개 기관, 관리자, 다른 사용자 1. 기관, 관리자(manager) 2. 기관(organ)
 * 6. 외부 검색 허용 - 0. FALSE 1. TRUE 
 * 7. 관련 정보 태그 - String문자열을 구분자 '|' 를 사용
 * 8. 케테고리 key
 * 9. 유효성(삭제)
 * 10. 생성날짜
 */
public class Board implements DTO{
	private int key;
	private String title;
	private int memberKey;
	private int pubType;
	private String content;
	private boolean search;
	private String tags;
	private int categoryKey;
	private boolean isValid;
	private Date date;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}
	public int getMemberKey() {
		return memberKey;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPubType() {
		return pubType;
	}
	public void setPubType(int pubType) {
		this.pubType = pubType;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getCategoryKey() {
		return categoryKey;
	}
	public void setCategoryKey(int categoryKey) {
		this.categoryKey = categoryKey;
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
	
	public Board getSample(){
		Board dto = new Board();
		dto.setContent("<h1>샘플 제목</h1><pre><code> public void sayHello(){ System.out.print(\"hello\"); } </code></pre>");
		dto.setMemberKey(0);
		dto.setPubType(0);
		dto.setSearch(true);
		dto.setTags("코드|헬로");
		dto.setTitle("헬로 출력하는 소스 공개합니다");
		return dto;
	}
}
