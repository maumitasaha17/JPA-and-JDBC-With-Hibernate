package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Address;
import bean.Employees;
import bean.Profile;

public class OneToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		// Persist Employee & Profile
		Employees emp = new Employees(101, "Ram", 121);
		Profile profile = new Profile(201, "9995500088", "ram@gmail.com");
		Address addr1 = new Address(301, "Chennai");
		Address addr2 = new Address(302, "Hyderabad");

		emp.setProfile(profile);
		;
		emp.getAddress().add(addr1);
		emp.getAddress().add(addr2);

		// Save employee
		em.persist(emp);

		// get employees based on id
		Employees employee = em.find(Employees.class, 101);
		System.out.println(employee);
		System.out.println(employee.getProfile());
		System.out.println(employee.getAddress());

		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();

	}

}
