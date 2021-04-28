package com.cg.insurance.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.insurance.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{

	
	
	
	@Override
	public Employee save(Employee employee) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	em.persist(employee);
	em.getTransaction().commit();
	em.close();
	emf.close();
	return employee;
	}
	

	@Override
	public List<Employee> getAllEmployees() {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Query query = em.createQuery("from Employee");
	List<Employee> employees = query.getResultList();
	em.getTransaction().commit();
	em.close();
	emf.close();
	return employees;	
	}
	
	
	@Override
	public Employee getEmployeeById(int id) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Employee emp = em.find(Employee.class, 9);
	em.getTransaction().commit();
	emf.close();
	em.close();
	return emp;	
	}
	
	
	@Override
	public Employee updateEmployee(Employee employee) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	//Get employee from db
	Employee emp = em.find(Employee.class, employee.getId());
	//update emp details
	emp.setName(employee.getName());
	emp.setDesignation(employee.getInsuranceScheme());
	emp.setSalary(employee.getSalary());	
	em.getTransaction().commit();
	emf.close();
	em.close();
	return emp;	
	}
	
	
	@Override
	public Employee deleteEmployeeById(int id) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Employee emp = em.find(Employee.class, 9);
	em.remove(emp);
	em.getTransaction().commit();
	emf.close();
	em.close();
	return emp;	
	}
	
}
