package com.oneplace.dao;

import com.util.kht.DAO;
import com.util.kht.SampleData;

public class OrgDAO extends DAO{
	private SampleData data = new SampleData();
	public boolean isDupName(String orgName) {
		return data.isDupName(orgName);
	}

}
