package com.blcl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blcl.domains.ContactDomain;
import com.blcl.domains.PersonsDomain;
import com.blcl.dtos.ContactDto;
import com.blcl.dtos.PersonsDto;

@Component
public class Mapper implements IMapper{

	@Override
	public List<PersonsDto> mapDto(List<PersonsDomain> domains) {
		PersonsDto personsDto = new PersonsDto();
		List<PersonsDto> personsDtoList = new ArrayList<PersonsDto>();
		
		ContactDto contactDto = new ContactDto();
		List<ContactDto> contactDtoList = new ArrayList<ContactDto>();
		
		for(PersonsDomain domain: domains){
			personsDto =  new PersonsDto();
			
			personsDto.setFirstName(domain.getFirstName());
			personsDto.setAge(domain.getAge());
			personsDto.setDateOfBirth(domain.getDateOfBirth());
			personsDto.setCity(domain.getAddressDomain().getCityDomain().getCityName());
			personsDto.setState(domain.getAddressDomain().getStateDomain().getStateName());
			
			contactDtoList = new ArrayList<ContactDto>();
			for(ContactDomain contact: domain.getContactDomain()){
				contactDto = new ContactDto();
				
				contactDto.setContactNumber(contact.getContactNumber());
				contactDto.setDescription(contact.getDescription());
				
				contactDtoList.add(contactDto);
			}
			personsDto.setContact(contactDtoList);
			
			personsDtoList.add(personsDto);
		}
		
		return personsDtoList;
	}
}
