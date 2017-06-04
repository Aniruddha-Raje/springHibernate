package com.blcl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blcl.dao.IDao;
import com.blcl.domains.PersonsDomain;
import com.blcl.dtos.PersonsDto;
import com.blcl.mapper.IMapper;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	IDao demoDao;
	
	@Autowired
	IMapper mapper;

	@Override
	public List<PersonsDto> getData() {
		
		List<PersonsDomain> personsDomain = demoDao.fetchDatafromDB();
		
		List<PersonsDto> personsDtos = mapper.mapDto(personsDomain);
		
		return personsDtos;
	}
	
	
}
