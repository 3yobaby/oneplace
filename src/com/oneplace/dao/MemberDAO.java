package com.oneplace.dao;

import com.oneplace.data.Member;
import com.util.kht.DAO;

public class MemberDAO extends DAO{
	private static MemberDAO instance;
	private MemberDAO() {}

	public Member login(String id, String pass){
		Member member = new Member();
		member.setId("testid");
		member.setName("테스터");
		return member;
	}

	public boolean join(Member member) {
		
		return false;
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			return instance = new MemberDAO();
		else return instance;
	}

	public boolean isDuplicatedId(String id) {
		System.out.println("implement isDupicatedId " + this);
		return true;
	}
}
