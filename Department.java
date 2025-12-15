package com.codegnan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int deptId;
private String deptName;
@OneToMany(cascade=CascadeType.ALL)
private List<Employee>employees=new ArrayList<>();
//helper method to add employees to the list
public void addEmployee(Employee emp) {
	employees.add(emp);
}
public Department(String deptName) {
	super();
	this.deptName = deptName;
}
@Override
public String toString() {
	return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employees=" + employees + "]";
}
	// TODO Auto-generated method stub
	
}

