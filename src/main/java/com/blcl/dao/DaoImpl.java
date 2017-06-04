package com.blcl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blcl.domains.PersonsDomain;

@Repository
public class DaoImpl implements IDao {
	
	@Autowired
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public List<PersonsDomain> fetchDatafromDB() {
		
		List<PersonsDomain> personsDomain = entitymanager.createQuery("FROM PersonsDomain", PersonsDomain.class).getResultList();
		//Set<ContactDomain> s = personsDomain.get(0).getContactDomain();
		
		return personsDomain;
	}
	
}
