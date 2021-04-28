package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Employees;

public class ReadDemo {

	public static void main(String[] args) {
		// Create Instance of EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		/*
		 * //Perform CRUD operations - Execute queries Query query =
		 * em.createQuery("from employee"); //from should match with class name
		 * List<Employee> employees = query.getResultList();
		 * 
		 * for(Employee emp:employees) { System.out.println(emp); }
		 */

		// get employee based on empId
		Employees emp = em.find(Employees.class, 151);
		System.out.println(emp);

		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();

	}

}