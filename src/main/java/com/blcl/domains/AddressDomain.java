package com.blcl.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Configurable
@Table(name = "Address")
public class AddressDomain implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AddressID")
	private int AddressID;

	@OneToOne
	@JoinColumn(name="City")
	private CityDomain cityDomain;

	@ManyToOne
	@JoinColumn(name = "State", nullable = true)
	@JsonBackReference
	private StateDomain stateDomain;

	public int getAddressID() {
		return AddressID;
	}

	public void setAddressID(int addressID) {
		AddressID = addressID;
	}

	public CityDomain getCityDomain() {
		return cityDomain;
	}

	public void setCityDomain(CityDomain cityDomain) {
		this.cityDomain = cityDomain;
	}

	public StateDomain getStateDomain() {
		return stateDomain;
	}

	public void setStateDomain(StateDomain stateDomain) {
		this.stateDomain = stateDomain;
	}

}
