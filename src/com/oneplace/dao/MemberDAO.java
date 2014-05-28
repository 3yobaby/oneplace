package com.oneplace.dao;

import com.oneplace.data.Member;
import com.oneplace.util.DAO;

public class MemberDAO extends DAO{
	public Member login(String id, String pass){
		/*
		 * 구현
		 */
		
		// 로그인 성공하면
		Member member = new Member();
		member.setId("testid");
		member.setName("테스터");
		return member;
	}
}
