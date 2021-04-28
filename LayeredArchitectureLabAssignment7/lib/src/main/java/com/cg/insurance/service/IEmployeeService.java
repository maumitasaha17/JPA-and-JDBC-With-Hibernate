package com.cg.insurance.service;

import java.util.List;

import com.cg.insurance.exception.EmployeeNotFoundException;
import com.cg.insurance.model.Employee;

public interface IEmployeeService {

	//persisting or saving the object in data base
	Employee save(Employee employee);
	//calling the save method to employe object and will return it to the Employee

	//see all the info from the table
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	Employee updateEmployee(Employee employee);
	Employee deleteEmployeeById(int id);

}
