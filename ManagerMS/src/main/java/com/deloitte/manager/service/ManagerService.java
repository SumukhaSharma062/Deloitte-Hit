package com.deloitte.manager.service;


import java.util.List;

import com.deloitte.manager.entity.Manager;
import com.deloitte.manager.model.EmpResponse;
import com.deloitte.manager.model.Employee;

public interface ManagerService {
	public Manager saveManager(Manager manager);
	public EmpResponse getEmpByManagerId(Integer managerId);
	

}
