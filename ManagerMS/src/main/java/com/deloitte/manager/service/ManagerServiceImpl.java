package com.deloitte.manager.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deloitte.manager.util.Utility;
import com.deloitte.manager.entity.Manager;
import com.deloitte.manager.exception.BusinessException;
import com.deloitte.manager.model.EmpResponse;
import com.deloitte.manager.model.Employee;
import com.deloitte.manager.repo.ManagerRepo;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private RestTemplate rTemp;
	
	
	@Autowired
	private ManagerRepo manRepo;
	
	@Override
	public Manager saveManager(Manager manager) {
		if(manager.getManagerName()==null || manager.getManagerName().length()==0) {
			throw new BusinessException("400", "Please add proper Manager name, this column cannot be blank");
		}
		if(manager.getAddress()==null || manager.getAddress().length()==0) {
			throw new BusinessException("400", "Please add proper address, this column cannot be blank");
		}
		if(manager.getLocation()==null ||manager.getLocation().length()==0) {
			throw new BusinessException("400", "Please add proper location, this coloumn cannot be blank");
		}
		try {
		return manRepo.save(manager);
	}catch(IllegalArgumentException e) {
		throw new BusinessException("400", "Given data is null,please add valid details" +e.getMessage());
	}catch(Exception e) {
		throw new BusinessException("400", "Something went wrong in Service layer,Try again!!" + e.getMessage());
		}
		
	}

	@Override
	public EmpResponse getEmpByManagerId(Integer managerId) {
		try{if (Utility.validateInt(managerId)) {
			
			if(!manRepo.findById(managerId).isPresent()) {
				throw new BusinessException("400","Manager does not exist");
			}
			
			Manager m1 = manRepo.findByManagerId(managerId);
			List<Employee> empList =  rTemp.getForObject("http://localhost:8080/employee/empl/"+managerId,List.class);
			
			EmpResponse resp3 = new EmpResponse(m1,empList);
			return resp3;
		}
		}catch(IllegalArgumentException e) {
			throw new BusinessException("400","Given id is null, please add valid details");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("400","Given id does not exist in database");
		}
		return null;
	
	}
}
	
