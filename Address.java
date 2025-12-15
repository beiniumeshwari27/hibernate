package com.codegnan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Address {
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", City=" + City + ", State=" + State + ", Pincode=" + Pincode + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int addrId;
private String City;
private String State;
private String Pincode;
@OneToOne

private Employee employee;
public Address(String city, String state, String pincode) {
	super();
	this.City = city;
	this.State = state;
	this.Pincode = pincode;
}

}