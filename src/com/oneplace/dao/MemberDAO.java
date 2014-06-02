package com.oneplace.dao;

import com.oneplace.data.Member;
import com.oneplace.util.DAO;

public class MemberDAO extends DAO{
	public MemberDAO() {
	}

	public Member login(String id, String pass){
		Member member = new Member();
		member.setId("testid");
		member.setName("테스터");
		return member;
	}

	public boolean join(Member member) {
		
		return false;
	}
}
