package com.util.kht;

import java.sql.Date;
import java.util.HashMap;

import com.oneplace.data.Cafe;
import com.oneplace.data.Manager;
import com.oneplace.data.Member;
import com.oneplace.data.Organization;
import com.oneplace.data.OrganizationManager;

public class SampleData {
	private static SampleData instance;
	private HashMap<String, Cafe> cafeMap; // string is url or id
	private HashMap<String, Member> memberMap;
	
	public static SampleData getInstance(){
		if(instance == null){
			return instance = new SampleData();
		}
		return instance;
	}
	private SampleData() {
		// init
		cafeMap =  new HashMap<String, Cafe>();
		memberMap= new HashMap<String, Member>();
		// 샘플 카페
		for (int i = 0; i < 10; i++) {
			Manager temp = new Manager();
			temp.setName("테스트메니저");
			Cafe cafe = new Cafe(temp);
			cafe.setName("테스트 카페" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setUri("testcafe.cafe");
			temp.setCafe(cafe);
			cafeMap.put(cafe.getUri(), cafe);
		}
		
		// 동성학원 메니저
		OrganizationManager orgmanager = new OrganizationManager();
		orgmanager.setName("동성학교장");
		orgmanager.setId("manager");
		orgmanager.setPass("1234");
		// 동성학교 추가
		Organization org = new Organization(orgmanager);
		org.setDate(new Date(System.currentTimeMillis()));
		org.setUri("dongsung.org");
		cafeMap.put("dongsung.org",org);
		orgmanager.setCafe(org);
		// 동성학교 카페 추가
		Manager member = new Manager();
		member.setName("603선생님");
		member.setId("manager603");
		member.setPass("1234");
		Cafe cafe = new Cafe(member);
		cafe.setName("603");
		cafe.setDate(new Date(System.currentTimeMillis()));
		member.setCafe(cafe);
		//
		Manager member2 = new Manager();
		member2.setName("604쌤");
		member2.setId("manager604");
		member2.setPass("1324");
		Cafe cafe2 = new Cafe(member2);
		cafe2.setName("604");
		cafe2.setDate(new Date(System.currentTimeMillis()));
		member2.setCafe(cafe2);
		org.addCafe(cafe);
		org.addCafe(cafe2);
		// put
		memberMap.put(orgmanager.getId(), orgmanager);
		memberMap.put(member.getId(), orgmanager);
		// 테스트 회원 추가
		Member member3 = new Member();
		member3.setId("test");
		member3.setName("테스트 회원");
		member3.setPass("1234");
		member3.setEmail("testemail@never.com");
		memberMap.put(member3.getId(), member3);
		for (int i = 0; i < 10; i++) { // 테스트 회원의 소속 카페 추가
			Member temp2 = new Manager();
			temp2.setName("샘플메니저" + i);
			temp2.setId("manager1");
			Cafe temp = new Cafe(temp2);
			temp.setName("테스트회원이 가입한 카페 " + i);
			temp.setDetail("카페설명........ " + i);
			temp.setDate(new Date(System.currentTimeMillis()));
			temp.setUri("testcafe"+i+".cafe");
			cafeMap.put(temp.getUri(), temp);
		}
		// 동성학원의 카페중 하나인 cafe에 테스트 회원 추가
		cafe.addMember(member);
	}
	
	public HashMap<String, Cafe> getAllCafe() {
		return cafeMap;
	}

	public boolean isDupCafeName(String orgName) {
		for(Cafe cafe : cafeMap.values()){
			if(cafe.getName().equals(orgName))
				return true;
		}
		return false;
	}
	public HashMap<String, Organization> getOrganizationList() {
		HashMap<String, Organization> temp = new HashMap<String, Organization>();
		for(Cafe cafe : cafeMap.values()){
			if(cafe instanceof Organization)
				temp.put(cafe.getUri(), (Organization)cafe);
		}
		return temp;
	}
	
	public boolean isDupCafeUri(String cafeUri) {
		for(Cafe cafe : cafeMap.values()){
			if(cafe.getUri().equals(cafeUri))
				return true;
		}
		return false;
	}
	public HashMap<String, Member> getAllMember() {
		return this.memberMap;
	}

}
