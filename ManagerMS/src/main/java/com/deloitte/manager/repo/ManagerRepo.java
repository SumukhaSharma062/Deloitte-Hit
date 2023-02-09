package com.deloitte.manager.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deloitte.manager.entity.Manager;
import com.deloitte.manager.model.Employee;

public interface ManagerRepo extends MongoRepository<Manager, Integer>{

	Manager findByManagerId(Integer managerId);
	
}
