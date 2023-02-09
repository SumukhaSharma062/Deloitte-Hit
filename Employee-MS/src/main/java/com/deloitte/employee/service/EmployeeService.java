package com.deloitte.employee.service;

import java.util.List;

import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.response.EmployeeResp;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public EmployeeResp addEmployee(Employee employee);
	public Employee getById(Integer empId);
	public void deleteEmployee(Integer empId);
	public Employee updateEmp(Employee employee, Integer empId);
}
