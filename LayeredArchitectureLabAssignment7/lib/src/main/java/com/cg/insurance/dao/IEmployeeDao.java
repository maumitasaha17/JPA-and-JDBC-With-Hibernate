package com.cg.insurance.dao;

import java.util.List;

import com.cg.insurance.model.Employee;

public interface IEmployeeDao {

	Employee save(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee);
	Employee deleteEmployeeById(int id);
}
