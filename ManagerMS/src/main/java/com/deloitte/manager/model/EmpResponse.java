package com.deloitte.manager.model;

import java.util.List;

import com.deloitte.manager.entity.Manager;

public class EmpResponse {
	private Manager manager;
	private List<Employee> employee;

	public EmpResponse() {
		super();
	}
	
	public EmpResponse(Manager manager, List<Employee> employee) {
		super();
		this.manager = manager;
		this.employee = employee;
	}

	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpResponse [manager=" + manager + ", employee=" + employee + "]";
	}
	
	
}