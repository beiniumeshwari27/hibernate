package com.codegnan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Branch {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int bid;
private String bname;
private String location;
	public Branch(String bname, String location) {
		super();
		this.bname = bname;
		this.location = location;
	}
	
}
