package com.oneplace.dao;

import java.util.ArrayList;

import com.oneplace.data.Organization;
import com.util.kht.DAO;
import com.util.kht.SampleData;

public class OrganizationDAO extends DAO{
	private SampleData data = SampleData.getInstance();
	public boolean isDupName(String orgName) {
		return data.isDupName(orgName);
	}
	public ArrayList<Organization> getOrganizationList() {
		return data.getOrganizationList();
	}

}
