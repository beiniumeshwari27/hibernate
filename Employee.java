package com.codegnan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int empId;
private String empName;
private double empSalary;
public Employee(String empName, double empSalary) {
	super();
	this.empName = empName;
	this.empSalary = empSalary;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
}

}