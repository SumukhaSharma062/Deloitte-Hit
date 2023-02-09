package com.deloitte.employee.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.employee.controller.EmployeeController;
import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.exception.BusinessException;
import com.deloitte.employee.repo.EmpRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmpRepo empRepo;
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class); 


	@Override
	public Employee saveEmp(Employee emp) {
		if(empRepo.findById(emp.getEmployeeId()).get()!=null) {
			throw new BusinessException("400","Employee Id already taken");
			}

		if (emp.getName()==null || emp.getName().length()==0) {
			throw new BusinessException("400", "Please add proper name, this column cannot be blank");
		}
		if(emp.getAddress()==null || emp.getAddress().length()==0) {
			throw new BusinessException("400", "Please add proper address, this column cannot be blank");
		}
		if(emp.getManagerId().equals(0)) {
			throw new BusinessException("400", "Please assign the Employee with a Manager");
		}
		try {
			return empRepo.save(emp);	
		}catch(IllegalArgumentException e) {
			throw new BusinessException("400", "Given data is null,please add valid details" +e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("400", "Something went wrong in Service layer,Try again!!" + e.getMessage());
		}
	}
	@Override
	public List<Employee> fetchEmployees() {
			List<Employee> list;
			try {
				list = empRepo.findAll();			
			}catch(Exception e) {
				throw new BusinessException("400","Something happened in the Service layer while fetching all employees"+e.getMessage());
			}
			
			if(list.isEmpty()) {
				throw new BusinessException("400","The list is empty, there is nothing to display");
			}
		return list;
	}
	@Override
	public Employee getEmpById(Integer employeeId) {
		try {
			return empRepo.findById(employeeId).get();
		}catch(IllegalArgumentException e) {
			throw new BusinessException("400","Given id is null, please add valid details"+e.getMessage());
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("400","Given id does not exist in database"+e.getMessage());
		}
	}
	@Override
	public Employee updateEmployees(Employee employee) {
		
		logger.info("Update started");
		Employee updEmployee ;

		try {
			updEmployee = empRepo.findById(employee.getEmployeeId()).get();
		}
		catch(Exception e) {
				
				logger.info("Error in update");
				throw new BusinessException("400","Employee does not exist");
			}
		
		if(Objects.nonNull(employee.getEmployeeId())) {
			updEmployee.setEmployeeId(employee.getEmployeeId());
		}
		if(Objects.nonNull(employee.getManagerId())){
			updEmployee.setManagerId(employee.getManagerId());
		}
		if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
			updEmployee.setName((employee.getName()));
		}else {
			throw new BusinessException("400","data name is null, please provice valid details");
		}
		if (Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress())) {
			updEmployee.setAddress(employee.getAddress());
		}else {
			throw new BusinessException("609","data Address is null, please provide valid details");
		}
		if(Objects.nonNull(employee.getLocation()) && !"".equalsIgnoreCase(employee.getLocation())) {
			updEmployee.setLocation(employee.getLocation());
		}else {
			throw new BusinessException("610","data location is null, please provide valid details");
		}
		
		try {
			return empRepo.save(updEmployee);
		}catch (Exception e) {
			throw new BusinessException("611","Something happened in the service layer while updating"+e.getMessage());
		}
	}
	@Override
	public void deleteEmp(Integer employeeId) {
try {
	empRepo.deleteById(employeeId);
}catch(IllegalArgumentException e) {
	throw new BusinessException("612","given id is null, please add valid details"+e.getMessage());
}catch(java.util.NoSuchElementException e) {
	throw new BusinessException("613","given id does not exist in the database"+e.getMessage());
}if(empRepo.existsById(employeeId)) {
	throw new BusinessException("614","Given id does not exist in database");
}
	}
	
	@Override
	public List<Employee> getEmpByName(String name) {
		return empRepo.findByName(name);
	}
	
		
	
}
