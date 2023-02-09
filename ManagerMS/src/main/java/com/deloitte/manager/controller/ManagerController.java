package com.deloitte.manager.controller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.deloitte.manager.exception.BusinessException;
import com.deloitte.manager.model.EmpResponse;
import com.deloitte.manager.model.Employee;
import com.deloitte.manager.repo.ManagerRepo;
import com.deloitte.manager.entity.Manager;
import com.deloitte.manager.service.ManagerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerRepo manRepo;

	@Autowired
	private ManagerService managerService;

	Logger logger = LoggerFactory.getLogger(ManagerController.class);

	@Operation(summary = "Add Manager", description = "Adding new managers to the list", tags = "Post")
	@PostMapping("/addManager")
	public ResponseEntity<?> saveManager(@RequestBody Manager manager) {
		try {
			managerService.saveManager(manager);
			String resp1 = "Data of New " + manager + " added";
			return new ResponseEntity<String>(resp1, HttpStatus.CREATED);
		} catch (BusinessException e) {

			logger.error("Exception in creating new Manager");

			return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/{managerId}")
	public ResponseEntity<?> getEmpByManagerId(@PathVariable("managerId") Integer managerId) {
		try {

			return new ResponseEntity<EmpResponse>(managerService.getEmpByManagerId(managerId), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>("Manager not in database", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
