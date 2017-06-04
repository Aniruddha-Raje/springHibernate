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
		PersonsDto p = null;
		List<PersonsDto> ps = new ArrayList<PersonsDto>();
		
		ContactDto c = null;
		List<ContactDto> cs = new ArrayList<ContactDto>();
		
		for(PersonsDomain domain: domains){
			p =  new PersonsDto();
			p.setFirstName(domain.getFirstName());
			p.setAge(domain.getAge());
			p.setDateOfBirth(domain.getDateOfBirth());
			p.setCity(domain.getAddressDomain().getCityDomain().getCityName());
			p.setState(domain.getAddressDomain().getStateDomain().getStateName());
			
			for(ContactDomain contact: domain.getContactDomain()){
				c = new ContactDto();
				c.setContactNumber(contact.getContactNumber());
				c.setDescription(contact.getDescription());
				cs.add(c);
			}
			p.setContact(cs);
			
			ps.add(p);
		}
		
		return ps;
	}
}
