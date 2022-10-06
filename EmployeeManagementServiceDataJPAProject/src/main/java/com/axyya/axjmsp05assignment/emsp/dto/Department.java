package com.axyya.axjmsp05assignment.emsp.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptID;

	@Column
	private String deptName;

	@OneToMany( mappedBy = "dept",targetEntity = Employee.class, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employees;

	public Department() {

	}

	public Department(long deptID, String deptName, Set<Employee> employees) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.employees = employees;
	}

	public long getDeptID() {
		return deptID;
	}

	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + ", employees=" + employees + "]";
	}

}
