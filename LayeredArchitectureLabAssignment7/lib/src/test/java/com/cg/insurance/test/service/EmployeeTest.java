package com.cg.insurance.test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.Id;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cg.insurance.exception.EmployeeNotFoundException;
import com.cg.insurance.model.Employee;
import com.cg.insurance.service.EmployeeServiceImpl;
import com.cg.insurance.service.IEmployeeService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {

	IEmployeeService empService;
	
	@BeforeEach
	void setUp() throws Exception {
		 empService = new EmployeeServiceImpl();
		//System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		empService = null;
		//System.out.println("tearDown");
	}

	/*
	 * private int id;
	private String name;
	private double salary;
	private String designation;
	private String insuranceScheme;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	void test() {
		System.out.println("Test");
		fail("Not yet implemented");
	}
	/*
	@Test
	void testA() {
		System.out.println("TestA");
		fail("Not yet implemented");
	}
	
	@Test
	void testB() {
		System.out.println("TestB");
		fail("Not yet implemented");
	}
	*/
	
	
	//TEST CASES
	@Test
	@Order(2)
	void testShouldAddEmployee() {
		//IEmployeeService empService=new EmployeeServiceImpl();
		
		Employee emp = new Employee();
		emp.setName("Ram");
		emp.setDesignation("Software Engineer");
		emp.setSalary(40000.00);
		emp.setInsuranceScheme("SchemeA");
	//now save the object in data base. 
	//methods need to be defined in service layer and dao
	
		Employee persistedEmp = empService.save(emp);
		System.out.println(persistedEmp);
		
		assertAll(
		()->assertEquals("Ram",persistedEmp.getName()),
		()->assertEquals("Software Engineer",persistedEmp.getDesignation()),
		()->assertEquals(40000.00,persistedEmp.getSalary()),
		()->assertEquals("SchemeA",persistedEmp.getInsuranceScheme()));
	
	}
	
	@Test
	@Disabled
	@Order(5)
	void testShouldDeleteEmployeeById() {
		//IEmployeeService empService=new EmployeeServiceImpl();
		Employee emp = empService.deleteEmployeeById(9);
		assertEquals(9,emp.getId());
	}
	
	@Test
	@Order(1)
	void testShouldGetAllEmployees() {
		//IEmployeeService empService = new EmployeeServiceImpl();
		List<Employee> employees = empService.getAllEmployees();
		assertEquals(3, employees.size());
		/*
		Employee emp1 = empService.getEmployeeById(9);
		Employee emp2 = empService.getEmployeeById(10);
		
		assertEquals(40000.00, emp1.getSalary());
		assertEquals(40000.00, emp2.getSalary());
		for(Employee emp :employees ) {
			System.out.println(emp);
		}
		*/
	}
	
	@Test
	//@Disabled
	void testShouldUpdateEmployee() {
		//IEmployeeService empService=new EmployeeServiceImpl();
		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("Ram Kumar");
		emp.setDesignation("Software Engineer");
		emp.setInsuranceScheme("Scheme B");
		emp.setSalary(45000.00);
		
		Employee updatedEmp = empService.updateEmployee(emp);
		System.out.println(updatedEmp);
		assertEquals(45000.00, updatedEmp.getSalary());
	}
	
	
	
	@Test
	@Order(3)
	void testShouldGetEmployeeById() throws EmployeeNotFoundException {
		//IEmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.getEmployeeById(9);
		assertEquals("Ram", emp.getName());
		//List<Employee> employees = empService.getAllEmployee();
		//for(Employee emp : employees) {
		//	System.out.println(emp);	
	}
	}
	
	/*
	@Test
	void testShouldGetEmployeeByName() {
		
	}
	
	@Test
	void testShouldGetEmployeeByEmail() {
		
	}
	
	@Test
	void testShouldGetEmployeeByContactNo() {
		
	}
	
	
	@Test
	void testShouldGetAllEmployeeById() {
		
	}
	
	
	 @Test
	void testShouldGetAllEmployeeByName() {
		
	}
	
	@Test
	void testShouldGetAllEmployeeByEmail() {
		
	}
	
	@Test
	void testShouldGetAllEmployeeByContactNo() {
		
	}
	*/
	

