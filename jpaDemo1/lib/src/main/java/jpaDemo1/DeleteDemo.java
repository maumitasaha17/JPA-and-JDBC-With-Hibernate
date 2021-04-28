package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Employees;

public class DeleteDemo {
	public static void main(String[] args) {
		// Create Instance of EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		// Perform CRUD operations - Execute queries
		Employees emp = em.find(Employees.class, 152);
		em.remove(emp);

		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();

	}

}