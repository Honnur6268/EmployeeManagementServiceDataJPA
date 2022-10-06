package com.axyya.axjmsp05assignment.emsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.axyya.axjmsp05assignment.emsp.dto.Department;
import com.axyya.axjmsp05assignment.emsp.dto.Employee;
import com.axyya.axjmsp05assignment.emsp.dto.Projects;

public interface EmployeeService {
//	ResponseEntity<Department> addDepartment(Department dept);
//	ResponseEntity<Projects> addProjects(Projects project);
	
	List<Employee> getEmployees();
	ResponseEntity<Employee> addEmployee(Employee emp);
	ResponseEntity<Employee> updateEmployee(Employee emp);
	ResponseEntity<Employee>  deleteEmployee(long code);
	Optional<Employee> getEmployeeById(long code);
	List<Employee> getByDeptName(String deptName);
	List<Employee> getByDeptNameIT();
	List<Employee> getByMaxTwoSalary();
	
	
}
