package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Employees;
import bean.Profile;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		/*
		 * //Persist Employee & Profile Employees emp = new Employees(101,"Ram",121);
		 * Profile profile = new Profile(201,"9995500088", "ram@gmail.com");
		 * 
		 * emp.setProfile(profile); em.persist(emp);
		 */

		// Accessing data
		Employees emp = em.find(Employees.class, 101);
		System.out.println(emp);
		System.out.println(emp.getProfile());

		Profile profile = em.find(Profile.class, 201);
		System.out.println(profile);
		System.out.println(profile.getEmployees());
		System.out.println(profile.getEmployee().getName());

		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();
	}

}
