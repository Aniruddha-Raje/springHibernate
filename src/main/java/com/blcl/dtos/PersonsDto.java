package com.blcl.dtos;

import java.util.Date;
import java.util.List;

public class PersonsDto {
	private String firstName;
	private int age;
	private Date dateOfBirth;
	private String city;
	private String state;
	private List<ContactDto> contact;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ContactDto> getContact() {
		return contact;
	}

	public void setContact(List<ContactDto> contact) {
		this.contact = contact;
	}

}
