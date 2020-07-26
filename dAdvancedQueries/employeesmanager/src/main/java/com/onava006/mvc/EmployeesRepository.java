package com.onava006.mvc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee,Long>{
	
	@Query("SELECT employee.first_name, employee.last_name FROM Employee employee JOIN Employee manager ON employee.manager_id = manager.id WHERE manager.id = ?1")
	public List<String[]> getEmployees(Long managerId);
	
	@Query("SELECT employee.first_name, employee.last_name, manager.first_name, manager.last_name FROM Employee employee JOIN Employee manager ON employee.manager_id = manager.id WHERE employee.id = ?1")
	public String[] getManagerFromEmployee(Long employeeId);
	
    //Implementar el modelo para que la relación self join funcione.
    //Implementar un método getter que permitirá a un Gerente obtener todos sus empleados.
    //Implementar un método getter que permitirá a un Empleado obtener su Gerente.

}
