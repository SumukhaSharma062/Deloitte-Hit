package com.deloitte.employee.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeResp {
	
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
	
		
	}


