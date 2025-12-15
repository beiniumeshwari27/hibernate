package com.codegnan.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Course {
	@Id
private String cid;
private String cname;
private int ccost;
@ManyToMany(cascade=CascadeType.ALL)
private Set<Student>students;
public Course(String cid, String cname, int ccost) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.ccost = ccost;
}

}