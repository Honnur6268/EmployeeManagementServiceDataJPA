package com.axyya.axjmsp05assignment.emsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axyya.axjmsp05assignment.emsp.dto.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//3. Write a JPQL query to retrieve all Employees in the IT Department.

	@Query("FROM Employee AS e LEFT JOIN e.dept AS d WHERE d.deptName = ?1")
	public List<Employee> findByDeptName(@Param("deptName") String deptName);
	
	@Query("FROM Employee AS e LEFT JOIN e.dept AS d WHERE d.deptName LIKE 'IT'")
	public List<Employee> findByDeptNameIT();
	
	
//4. Write a native JOIN Query that produces a report of top two employees drawing the maximum salary
	@Query(value = "SELECT * FROM Employee GROUP BY salary ORDER BY salary DESC LIMIT 2", nativeQuery = true)
	public List<Employee> findBySalary();
}
