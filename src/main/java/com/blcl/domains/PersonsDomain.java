package com.blcl.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
@Entity - marks this class as an entity bean
@Table - 
Attributes - name , catalogue, schema

@GeneratedValue - strategy, generator
@Column - name , length , nullable , unique

*/

@Entity
@Configurable
@Table(name = "Persons")
public class PersonsDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PersonID")
	private int personId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "Age")
	private int age;

	@Column(name = "DateOfBirth")
	private Date dateOfBirth;

	@OneToOne
	@JoinColumn(name = "Address")
	private AddressDomain addressDomain;

	@OneToMany(mappedBy = "PersonID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private List<ContactDomain> contactDomain = new ArrayList<ContactDomain>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressDomain getAddressDomain() {
		return addressDomain;
	}

	public void setAddressDomain(AddressDomain addressDomain) {
		this.addressDomain = addressDomain;
	}

	public List<ContactDomain> getContactDomain() {
		return contactDomain;
	}

	public void setContactDomain(List<ContactDomain> contactDomain) {
		this.contactDomain = contactDomain;
	}

}
