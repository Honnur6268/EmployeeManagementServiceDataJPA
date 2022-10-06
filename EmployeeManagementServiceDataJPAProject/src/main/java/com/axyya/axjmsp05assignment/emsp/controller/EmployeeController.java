package com.axyya.axjmsp05assignment.emsp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.axjmsp05assignment.emsp.dto.Employee;
import com.axyya.axjmsp05assignment.emsp.exception.InvalidEmployeeIDException;
import com.axyya.axjmsp05assignment.emsp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employeeById/{code}")
	public Optional<Employee> getEmployeeByID(@PathVariable long code) {
		Optional<Employee> empByID = employeeService.getEmployeeById(code);

		if (empByID.isPresent()) {
			return empByID;
		} else {
			throw new InvalidEmployeeIDException(
					"Employee code " + code + " is Not Found. Please try again with valid code!.");
		}
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployees();
	}

	@PostMapping("/addEmployee")
	@ExceptionHandler(InvalidEmployeeIDException.class)
	public ResponseEntity<?> addEmployees(@RequestBody Employee emp) {
		ResponseEntity<Employee> e = employeeService.addEmployee(emp);

		return e;
	}

	@PutMapping("/updateEmployee")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
	public ResponseEntity<?> updateEmployees(@RequestBody Employee emp) {
		ResponseEntity<Employee> e = employeeService.updateEmployee(emp);

		return e;
	}

	@DeleteMapping("/deleteEmployee/{code}")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
	public ResponseEntity<?> deleteEmployees(@PathVariable long code) {
		ResponseEntity<Employee> e = employeeService.deleteEmployee(code);
		return e;
	}

	@GetMapping("/byDeptName/{deptName}")
	public List<Employee> getEmplopyeeByDeptName(@PathVariable String deptName) {
		List<Employee> empByDeptName = employeeService.getByDeptName(deptName);
		if (empByDeptName.isEmpty()) {
			throw new InvalidEmployeeIDException(
					"Department Name " + deptName + " is Not Found. Please try again with valid department name!.");
		} else {

			return empByDeptName;
		}
	}

	@GetMapping("/byDeptName-IT")
	public List<Employee> getEmplopyeeByDeptName() {
		List<Employee> empByDeptName = employeeService.getByDeptNameIT();

		return empByDeptName;

	}

	@GetMapping("/getEmployeeByMaxTwoSalary")
	public List<Employee> getByMaxTopTwoSalary() {
		return employeeService.getByMaxTwoSalary();
	}
	
//	Save the department and projects first then perform the employee operation
//	@PostMapping("/addDepartment")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
//	public ResponseEntity<?> addDepartment(@RequestBody Department dept) {
//		ResponseEntity<Department> department = employeeService.addDepartment(dept);
//
//		return department;
//	}
	
//	@PostMapping("/addProject")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
//	public ResponseEntity<?> addProject(@RequestBody Projects proj) {
//		ResponseEntity<Projects> project = employeeService.addProjects(proj);
//
//		return project;
//	}
}
