package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Employees;

public class UpdateDemo {

	public static void main(String[] args) {
		// Create Instance of EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		// Perform CRUD operations - Execute queries
		// fetch data from database to update it
		Employees emp = em.find(Employees.class, 152);
		emp.setName("Sita");
		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();

	}

}