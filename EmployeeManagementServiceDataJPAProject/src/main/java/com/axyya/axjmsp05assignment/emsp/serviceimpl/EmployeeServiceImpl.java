package com.axyya.axjmsp05assignment.emsp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.axyya.axjmsp05assignment.emsp.dto.Department;
import com.axyya.axjmsp05assignment.emsp.dto.Employee;
import com.axyya.axjmsp05assignment.emsp.dto.Projects;
import com.axyya.axjmsp05assignment.emsp.exception.InvalidEmployeeIDException;
import com.axyya.axjmsp05assignment.emsp.repository.DepartmentRepository;
import com.axyya.axjmsp05assignment.emsp.repository.EmployeeRepository;
import com.axyya.axjmsp05assignment.emsp.repository.ProjectsRepository;
import com.axyya.axjmsp05assignment.emsp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

//	@Autowired
//	ProjectsRepository projectsRepository;

	@Override
	public Optional<Employee> getEmployeeById(long code) {
		Optional<Employee> employee = employeeRepository.findById(code);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		return employees;
	}

	@Override
	public ResponseEntity<Employee> addEmployee(Employee emp) {

		Optional<Employee> exisitingEmployee = employeeRepository.findById(emp.getCode());
		if (!exisitingEmployee.isPresent()) {
			employeeRepository.save(emp);
			return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		} else {
			throw new InvalidEmployeeIDException(
					"Employee details with code " + emp.getCode() + " is already present.");
		}
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Employee emp) {
		Optional<Employee> exisitingEmployee = employeeRepository.findById(emp.getCode());
		if (exisitingEmployee.isPresent()) {
			employeeRepository.save(emp);
			return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);

		} else {
			throw new InvalidEmployeeIDException("Employee with code " + emp.getCode()
					+ " is Not Found. Please try to update with correct Employee ID.");
		}

	}

	@Override
	public ResponseEntity<Employee> deleteEmployee(long code) {
		Optional<Employee> exisitingEmployee = employeeRepository.findById(code);

		if (exisitingEmployee.isPresent()) {

			employeeRepository.deleteById(code);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		} else {
			throw new InvalidEmployeeIDException("Employee with code " + code + " is Not Found.");
		}

	}

	@Override
	public List<Employee> getByDeptName(String deptName) {
		List<Employee> departments = (List<Employee>) employeeRepository.findByDeptName(deptName);

		return departments;
	}

	@Override
	public List<Employee> getByDeptNameIT() {
		List<Employee> departments = (List<Employee>) employeeRepository.findByDeptNameIT();

		return departments;
	}

	@Override
	public List<Employee> getByMaxTwoSalary() {
		List<Employee> employees = (List<Employee>) employeeRepository.findBySalary();

		return employees;
	}
	
//	Save the department and projects first then perform the employee operation
//	@Override
//	public ResponseEntity<Department> addDepartment(Department dept) {
//		Optional<Department> exisitingDepartment = departmentRepository.findById(dept.getDeptID());
//		if (!exisitingDepartment.isPresent()) {
//			departmentRepository.save(dept);
//			return new ResponseEntity<Department>(dept, HttpStatus.CREATED);
//		} else {
//			throw new InvalidEmployeeIDException(
//					"Department details with id " + dept.getDeptID() + " is already present.");
//		}
//	}
//
//	@Override
//	public ResponseEntity<Projects> addProjects(Projects project) {
//		Optional<Projects> exisitingProjects = projectsRepository.findById(project.getProjectID());
//		if (!exisitingProjects.isPresent()) {
//			projectsRepository.save(project);
//			return new ResponseEntity<Projects>(project, HttpStatus.CREATED);
//		} else {
//			throw new InvalidEmployeeIDException(
//					"Project details with id " + project.getProjectID() + " is already present.");
//		}
//	}

}
