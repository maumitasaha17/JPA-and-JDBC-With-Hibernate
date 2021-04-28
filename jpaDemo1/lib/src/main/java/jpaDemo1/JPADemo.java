package jpaDemo1;
/*
 * Jpa is a specification provides interfaces, classes and method to persist objects.
 * 
 * eg: JPA implementations are
 * ORM tools - ojbect relational mapping
 * Hibernate - commonly used orm tool 
 * iBatis
 * EclipseLink
 * TopLin
 * OpenJPA
 * 
 * eg:
 * defining class in Object orientation programing
 * 	class Student{
 * 		long rollNo;
 * 		String name;
 * 		int age;
 * }
 * 
 * Hibernate -using tables we are going to store data
 * 
 * student -
 * columns: rollNo int;
 * 			name varchar(50);
 * 			age int;
 * 
 * 
 * in relational database you can link the multiple tables using primary key and foriegn key
 * Primary key - unique data base
 * foriegn key - multiple tables in one database
 * 
 * TO WORK WITH JPA
 * get dependencies - hibernate-entitymanager
 * 
 *  https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
 *  implementation group: 'org.hibernate', name: 'hibernate-entitymanager', version: '5.4.30.Final'
 * 
 * EntityManagerFactory(I)- create EntityManager
 * EntityManager(I) - CRUD operations on db
 * Entity(C)- class having properties that need to be persist in db
 * 
 * 
 * MAPPINGS
 * 	OneToOne	
 * 		Employee & Profile
 * 
 * 
 * Unidirectional OneToOne Mapping
 * Bidirectional OneToOne  Mapping 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Employees;

public class JPADemo {

	public static void main(String[] args) {
		// Create Instance of EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

		// Create Instance of EntityManager using EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Being transaction
		em.getTransaction().begin();

		// Perform CRUD operations - Execute queries
		Employees emp1 = new Employees(150, "Geeta", 201);
		Employees emp2 = new Employees(151, "Sam", 202);
		Employees emp3 = new Employees(152, "Ram", 203);
		Employees emp4 = new Employees(153, "Sita", 204);
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);

		// Commit transation
		em.getTransaction().commit();

		// Release the resources.
		em.close();
		emf.close();

	}

}
