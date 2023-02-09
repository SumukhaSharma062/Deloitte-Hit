package com.deloitte.employee.service;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.repo.EmployeeRepo;
import com.deloitte.employee.response.EmployeeResp;
import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.custom.exception.BusinessException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	private List<Employee> employees = new ArrayList<>(Arrays.asList());
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeResp addEmployee(Employee employee) {
		
		
			Employee emp= employeeRepo.save(employee);
		EmployeeResp response=new EmployeeResp();
		response.setEmpId(emp.getEmpId());
		return response;
	}
	
	@Override
	public Employee getById(Integer empId) {
		// TODO Auto-generated method stub
		Employee findId =  employeeRepo.findById(empId).get();
		if(findId!=null) {
			return findId;
		}else {
			throw new UserNotFoundException();
		}
	}

	public void deleteEmployee(Integer empId) {
		employeeRepo.deleteByEmpId(empId);		
	}

	@Override
	public Employee updateEmp(Employee employee, Integer empId) {
     Employee updEmployee ;
		try {
		 updEmployee = employeeRepo.findById(empId).get();
		
		 if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
			 updEmployee.setName(employee.getName());}
		 if (Objects.nonNull(employee.getLocation()) &&!"".equalsIgnoreCase(employee.getLocation())){
			 updEmployee.setLocation(employee.getLocation());
			 
			 return employeeRepo.save(updEmployee);
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	}

