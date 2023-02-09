package com.deloitte.employee.entity;

import java.util.Date;

@
public class Employee {
	private Integer id;
	private String name;
	private String location;
	private Date doj;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Employee(Integer id, String name, String location, Date doj) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.doj = doj;
	}
	
}
