package com.blcl.dao;

import java.util.List;

import com.blcl.domains.PersonsDomain;

public interface IDao {
	List<PersonsDomain> fetchDatafromDB();
}
