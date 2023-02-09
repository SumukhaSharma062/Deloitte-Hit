package com.deloitte.employee.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "Employee")
public class Employee {
	
	@NotNull(message = "Emplpoyee ID cannot be null")
	private Integer empId;
	private String name;
	private String location;
	private Date doj;
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Employee(Integer empId, String name, String location, Date doj) {
		super();
		this.empId = empId;
		this.name = name;
		this.location = location;
		this.doj = doj;
	}	
	
}
