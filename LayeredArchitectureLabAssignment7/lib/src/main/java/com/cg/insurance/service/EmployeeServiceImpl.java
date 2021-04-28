package com.cg.insurance.service;

import java.util.List;

import com.cg.insurance.dao.EmployeeDaoImpl;
import com.cg.insurance.dao.IEmployeeDao;
import com.cg.insurance.exception.EmployeeNotFoundException;
import com.cg.insurance.model.Employee;


public class EmployeeServiceImpl  implements IEmployeeService{
	/*
	//Create instance in dao 
	IEmployeeDao empDao=new EmployeeDaoImpl();
	//EmployeeDao empDao=new EmployeeDaoImpl();
	
		
	@Override
	public Employee save(Employee employee) {
		//sevice layer shold call the dao to save the method
		return empDao.save(employee);
		}
		*/
	IEmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public Employee save(Employee employee) {
		return empDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		if(empDao.getEmployeeById(id) == null) {
			throw new EmployeeNotFoundException("Employee not found with id: "+id);
		}
		return empDao.getEmployeeById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployeeById(int id) {
		return empDao.deleteEmployeeById(id);
	}
}
