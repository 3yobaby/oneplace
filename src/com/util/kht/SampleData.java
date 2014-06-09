package com.util.kht;

import java.sql.Date;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.data.Cafe;
import com.oneplace.data.Member;
import com.oneplace.data.Organization;

public class SampleData {
	private static SampleData instance;
	private ArrayList<Cafe> cafeList;
	private ArrayList<Member> memberList;
	private ArrayList<Organization> orgList;
	
	public static SampleData getInstance(){
		if(instance == null){
			return instance = new SampleData();
		}
		return instance;
	}
	private SampleData() {
		// init
		memberList = new ArrayList<Member>();
		cafeList = new ArrayList<Cafe>();
		orgList = new ArrayList<Organization>();
		// 샘플 카페
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setName("테스트 카페" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			Member temp = new Member();
			temp.setName("테스트메니저");
			cafe.setManager(temp);
			cafeList.add(cafe);
		}
		// 동성학교 추가
		Organization org = new Organization("동성직업전문학교");
		org.setDate(new Date(System.currentTimeMillis()));
		org.setUri("/dongsung.org");
		orgList.add(org);
		// 동성학교 카페 추가
		Cafe cafe = new Cafe();
		cafe.setName("603");
		cafe.setDate(new Date(System.currentTimeMillis()));
		cafe.setOrganization(org);
		cafe.setManager(new Member());
		Cafe cafe2 = new Cafe();
		cafe2.setName("604");
		cafe2.setDate(new Date(System.currentTimeMillis()));
		cafe2.setOrganization(org);
		cafe2.setManager(new Member());
		org.addCafe(cafe);
		org.addCafe(cafe2);
		// 동성학원 메니저
		Member orgmanager = new Member();
		orgmanager.setName("동성학교장");
		orgmanager.setId("manager");
		orgmanager.setPass("1234");
		orgmanager.addCafe(cafe);
		orgmanager.addCafe(cafe2);
		orgmanager.setCafe(org);
		orgmanager.setOrgMember(true);
		org.setManager(orgmanager);
		memberList.add(orgmanager);
		// 테스트 회원 추가
		Member member = new Member();
		member.setId("testid");
		member.setName("테스트 회원");
		member.setPass("1234");
		member.setEmail("testemail@never.com");
		memberList.add(member);
		for (int i = 0; i < 10; i++) { // 테스트 회원의 소속 카페 추가
			Cafe temp = new Cafe();
			temp.setName("테스트회원이 가입한 카페 " + i);
			temp.setDetail("카페설명........ " + i);
			temp.setDate(new Date(System.currentTimeMillis()));
			Member temp2 = new Member();
			temp2.setName("샘플메니저" + i);
			temp.setManager(temp2);
			member.addCafe(cafe);
		}
		// 동성학원의 카페중 하나인 cafe에 테스트 회원 추가
		cafe.addMember(member);
	}
	
	public ArrayList<Cafe> getCafeBySearchWord(String word) {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (Cafe cafe : cafeList) {
			if(cafe.hasSearchWord(word)){
				list.add(cafe);
			}
		}
		return list;
	}

	public ArrayList<Cafe> getAllCafeList() {
		return cafeList;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getJSONArraySample() {
		JSONArray arr = new JSONArray();
		// json1
		JSONObject json1 = new JSONObject();
		json1.put("title", "제목 1");
		json1.put("name", "김희택");
		json1.put("date", "2014-01-27");
		arr.add(0, json1);
		// json2
		JSONObject json2 = new JSONObject();
		json2.put("title", "제목 2");
		json2.put("name", "이한일");
		json2.put("date", "2014-03-22");
		arr.add(1, json2);
		return arr;
	}

	public boolean isDupName(String orgName) {
		System.out.println(this + " isDUpName is not implemented");
		return false;
	}

	public Member getMember(String id){
		for(Member member : memberList){
			if(member.getId().equals(id))
				return member;
		}
		return null;
	}
	public ArrayList<Organization> getOrganizationList() {
		return this.orgList;
	}

}
