package com.blcl.services;

import java.util.List;

import com.blcl.domains.PersonsDomain;
import com.blcl.dtos.PersonsDto;

public interface IService {
	
	List<PersonsDto> getData();
}
