package com.deloitte.employee.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeTable")

public class Employee {

	@Id
	private Integer employeeId;
	private Integer managerId;
	private String name;
	private String address;
	private String location;

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", managerId=" + managerId + ", name=" + name + ", address="
				+ address + ", location=" + location + "]";
	}

	public Employee(Integer employeeId, Integer managerId, String name, String address, String location) {
		super();
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.name = name;
		this.address = address;
		this.location = location;
	}

	public Employee() {
		super();
	}
}
