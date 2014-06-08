package com.oneplace.dao;

import org.json.simple.JSONObject;

import com.oneplace.data.Member;
import com.util.kht.DAO;
import com.util.kht.SampleData;

public class MemberDAO extends DAO{
	private SampleData data = new SampleData();
	public MemberDAO() {}

	public JSONObject login(String id, String pass){
		return data.getLoginMember();
	}

	public boolean addMember(Member member) {
		System.out.println("implement joinMember " + this);
		return false;
	}

	public boolean isDuplicatedId(String id) {
		System.out.println("implement isDupicatedId " + this);
		return true;
	}
	
	// 아이디/비밀번호 찾기
	public boolean hasMemberByEmail(String parameter) {
		return false;
	}

}
