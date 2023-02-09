package com.deloitte.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.repo.EmployeeRepo;
import com.deloitte.employee.response.EmployeeResp;
import com.deloitte.employee.service.EmployeeService;
import com.deloitte.employee.entity.Employee;
import com.deloitte.employee.custom.exception.BusinessException;
import com.deloitte.employee.custom.exception.ControllerException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RestController
@RequestMapping("/employee")
@JsonInclude(Include.NON_NULL)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepo empRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		
		LOGGER.info("Employee find all");
		
		List<Employee> empList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		
		LOGGER.info("Employee add");
		
		EmployeeResp empSaved = employeeService.addEmployee(employee);
		return new ResponseEntity<EmployeeResp>(empSaved, HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer empId) {
	
		LOGGER.info("Employee find = {id}",empId);
		
			List<Employee> e1 = empRepo.findByEmpId(empId);
			return new ResponseEntity<List<Employee>>(e1, HttpStatus.OK);	
		}

	@PutMapping("/editEmp/{id}")
public ResponseEntity<?> updateEmp(@RequestBody Employee employee, @PathVariable("id")Integer empId){
		
	Employee response2 = employeeService.updateEmp(employee, empId);
		return new ResponseEntity<Employee>(response2,HttpStatus.OK);
}

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer empId) {
		try {
			employeeService.deleteEmployee(empId);

			String response2 = "Employee " + empId + " is deleted";
			return new ResponseEntity<String>(response2, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Incorrect employee ID", HttpStatus.BAD_REQUEST);
		}
			
	}

}
