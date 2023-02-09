package com.deloitte.employee.service;
import java.util.List;


import com.deloitte.employee.entity.Employee;

public interface EmployeeService {

	public Employee saveEmp(Employee emp);
	public List<Employee> fetchEmployees();
	public Employee getEmpById(Integer employeeId);
	public Employee updateEmployees(Employee employee);
	public void deleteEmp(Integer employeeId);
	public List<Employee> getEmpByName(String name);
}
