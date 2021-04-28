package jpaDemo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Author;
import bean.Book;
import bean.Employees;
import bean.Profile;

public class ManyToMany {
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

	// Create Instance of EntityManager using EntityManagerFactory
	EntityManager em = emf.createEntityManager();

	// Being transaction
	em.getTransaction().begin();

	
	//Persist Employee & Profile
	Book book1 = new Book(501,"Java");
	Book book2 = new Book(501,"Python");
	
	Author author1 = new Author(601,"Ram");
	Author author2 = new Author(601,"Sam");
	
	
	book1.getAuthor().add(author1);
	book1.getAuthor().add(author2);
	
	book2.getAuthor().add(author2);
	
	author1.getBook().add(book1);
	//author2.getBook().add(book1);
	author2.getBook().add(book2);
	
	//save objects
	em.persist(book1);
	em.persist(book2);
	em.persist(author1);
	em.persist(author2);
	
	
	//get books
	Book book = em.find(Book.class, 501);
	System.out.println(book.getTitle());
	System.out.println(book.getAuthor());
	
	Author author = em.find(Author.class, 602);
	System.out.println(author.getName());
	System.out.println(author.getBook());
	
	
	
	// Commit transation
	em.getTransaction().commit();

	// Release the resources.
	em.close();
	emf.close();
}

}

}
