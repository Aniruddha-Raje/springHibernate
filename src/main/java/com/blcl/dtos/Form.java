package com.blcl.dtos;

import java.util.List;

import com.blcl.domains.PersonsDomain;

public class Form {
	private String responseCode;
	private String responseMessage;
	private List<PersonsDto> data;
	// private List<PersonsDomain> persons;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<PersonsDto> getData() {
		return data;
	}

	public void setData(List<PersonsDto> data) {
		this.data = data;
	}

	/*
	 public List<PersonsDomain> getPersons() { return persons; }
	  
	 public void setPersons(List<PersonsDomain> persons) { this.persons =
	 persons; }
	 */

}
