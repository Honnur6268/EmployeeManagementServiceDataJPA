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
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectID;

	@Column
	private String projectName;

	@OneToMany(mappedBy = "projects", targetEntity = Employee.class, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employees;

	public Projects() {

	}

	public Projects(long projectID, String projectName, Set<Employee> employees) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.employees = employees;
	}

	public long getProjectID() {
		return projectID;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Projects [projectID=" + projectID + ", projectName=" + projectName + ", employees=" + employees + "]";
	}

	
}
