package com.blcl.mapper;

import java.util.List;

import com.blcl.domains.PersonsDomain;
import com.blcl.dtos.PersonsDto;

public interface IMapper {
	List<PersonsDto> mapDto(List<PersonsDomain> domains);
}
