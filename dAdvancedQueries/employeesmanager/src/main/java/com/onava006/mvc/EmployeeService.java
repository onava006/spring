package com.onava006.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired 
	EmployeesRepository repo;

	public List<String[]> getdudes(Long managerId){
		return repo.getEmployees(managerId);
	}
	
	public ArrayList<String> getmanager(Long employeeId) {
		String[] workersArray = repo.getManagerFromEmployee(employeeId);
		
		ArrayList<String> workerRelationship = new ArrayList<String>();
		
		for (String s: workersArray) {
			workerRelationship.add(s);
		}
		
		return workerRelationship;
	}
}
