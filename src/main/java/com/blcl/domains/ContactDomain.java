package com.blcl.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Configurable
@Table(name = "Contact")
public class ContactDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ContactID")
	private int contactId;

	@Column(name = "ContactNumber")
	private int contactNumber;

	@ManyToOne
	@JoinColumn(name = "PersonID", nullable = true)
	@JsonBackReference
	private PersonsDomain PersonID;

	@Column(name = "Description")
	private String description;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public PersonsDomain getPersonID() {
		return PersonID;
	}

	public void setPersonID(PersonsDomain personID) {
		PersonID = personID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
