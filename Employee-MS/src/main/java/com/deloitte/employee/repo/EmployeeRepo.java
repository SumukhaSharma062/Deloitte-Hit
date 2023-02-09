package com.deloitte.employee.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.deloitte.employee.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
	
	/* List<Employee> employees = new ArrayList<Employee>(); */
	
	List<Employee> findByEmpId(Integer empId);
	void deleteByEmpId(Integer empId);
	/*public default String edit(Employee employee) {
		employees.stream().filter(e->e.getEmpId() == employee.getEmpId()).forEach(e->{
			e.setName(employee.getName());
			e.setLocation(employee.getLocation());
		});
		return "Successfully updated";*/
	}
