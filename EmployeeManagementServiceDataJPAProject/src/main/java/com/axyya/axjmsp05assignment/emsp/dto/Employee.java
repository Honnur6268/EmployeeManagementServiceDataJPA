package com.axyya.axjmsp05assignment.emsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;

	@Column
	private String name;

	@Column
	private String role;
	
	@Column
	private double salary;

	@Column
	private int age;

	@ManyToOne(cascade = CascadeType.PERSIST,targetEntity = Department.class)
	@JoinColumn(name = "deptID", insertable = true)
	private Department dept;

	@ManyToOne(cascade = CascadeType.PERSIST,targetEntity = Projects.class)
	@JoinColumn(name = "projectID", insertable = true)
//	@JsonIgnore
	private Projects projects;

	@Column
	private String address;

	public Employee() {

	}

	public Employee(long code, String name, String role, double salary, int age, Department dept, Projects projects,
			String address) {
		super();
		this.code = code;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.age = age;
		this.dept = dept;
		this.projects = projects;
		this.address = address;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", role=" + role + ", salary=" + salary + ", age=" + age
				+ ", dept=" + dept + ", projects=" + projects + ", address=" + address + "]";
	}

}
