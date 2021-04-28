package com.cg.insurance.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.insurance.exception.EmployeeNotFoundException;
import com.cg.insurance.model.Employee;
import com.cg.insurance.service.EmployeeServiceImpl;
import com.cg.insurance.service.IEmployeeService;
//log4j2 api
/*
* Trace - most detail info
Debug -  
Info   - interesting runtime events
warn   - 
error  - run time errors
fatal  - severe errors that cause premature termination
off    - turn off logging
*/


public class MainUtils {
	Logger logger = LogManager.getLogger(MainUtils.class);

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String choice = null;
		IEmployeeService empService = new EmployeeServiceImpl();
		logger.info("Instantiated EmployeeService instance");
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Get Employee");
			System.out.println("4. Get All Employee");
			System.out.println("5. Delete Employee");
			System.out.println("Enter your choice: ");
			int selectedOption = sc.nextInt();
			logger.info(String.format("User Selected option %d", selectedOption));
			/*
			 * private String name; private double salary; private String designation;
			 * private String insuranceScheme; Salary Designation Insurance scheme >5000 and
			 * < 20000 System Associate Scheme C
			 * 
			 * >=20000 and <40000 Programmer Scheme B
			 * 
			 * >=40000 Manager Scheme A
			 * 
			 * <5000 Clerk No Scheme
			 * 
			 */
			String insuranceScheme = null;
			switch (selectedOption) {
			case 1:
				System.out.println("Enter your name: ");
				String name = br.readLine();
				System.out.println("Enter your salary: ");
				double salary = sc.nextDouble();
				System.out.println("Enter your designation: ");
				String designation = br.readLine();

				// int age = Integer.parseInt(br.readLine());
				// double salary1 = Double.parseDouble(br.readLine());

				/*
				 * System.out.println("Enter address details: ");
				 * System.out.println("Enter city name: "); String city = sc.next();
				 * 
				 * Address address = new Address(city);
				 */

				if ((salary > 5000.0 && salary < 20000.0) && designation.equalsIgnoreCase("System Associate")) {
					System.out.println("Eligible insurance scheme is 'Scheme C'");
					insuranceScheme = "Scheme C";
				} else if ((salary >= 20000.0 && salary < 40000.0) && designation.equalsIgnoreCase("Programmer")) {
					System.out.println("Eligible insurance scheme is 'Scheme B'");
					insuranceScheme = "Scheme B";
				} else if (salary >= 40000.0 && designation.equalsIgnoreCase("Manager")) {
					System.out.println("Eligible insurance scheme is 'Scheme A'");
					insuranceScheme = "Scheme A";
				} else if (salary < 5000.0 && designation.equalsIgnoreCase("Clerk")) {
					System.out.println("You are not eligible for any insurance scheme");
					insuranceScheme = "No Scheme";
				}
				System.out.println(insuranceScheme);
				Employee emp = new Employee(name, salary, designation, insuranceScheme);
				logger.info("Created employee object with user input details");
				// emp.setAddress(address);
				Employee employee = empService.save(emp);
				logger.info(String.format("employee %s saved successfully!", employee.getName()));
				System.out.println(employee.getName() + " is added successfully in the db");
				break;
			case 2:
				System.out.println("Enter your emp id: ");
				int empId1 = sc.nextInt();
				System.out.println("Enter your name: ");
				String name1 = sc.next();

				Employee employee1;
				try {
					employee1 = empService.getEmployeeById(empId1);
					employee1.setName(name1);
					System.out.println("Before update: " + employee1);
					Employee e1 = empService.updateEmployee(employee1);
					System.out.println("After update: " + e1);
					System.out.println(e1.getId() + " is updated successfully!");
					logger.debug("empId: %d Employee updated successfully!", e1.getId());

				} catch (EmployeeNotFoundException e2) {
					logger.error(e2.getMessage());
					System.out.println(e2.getMessage());
				}

				break;
			case 3:
				System.out.println("Enter employee id");
				int empId = sc.nextInt();
				Employee em;
				try {
					em = empService.getEmployeeById(empId);
					System.out.println(em);
				} catch (EmployeeNotFoundException e1) {
					System.out.println(e1.getMessage());
					// e1.printStackTrace();
				}

				break;
			case 4:

				List<Employee> employees = empService.getAllEmployees();
				for (Employee e : employees) {
					System.out.println(e.getId() + "\t\t" + e.getName() + "\t\t" + e.getSalary() + "\t\t"
							+ e.getDesignation() + "\t\t" + e.getInsuranceScheme());
				}
				break;
			case 5:
				System.out.println("Enter employee id that needs to be deleted: ");
				Employee empl = empService.deleteEmployeeById(sc.nextInt());
				System.out.println(empl.getName() + " deleted successfully!");
				break;
			default:
				System.out.println("Please enter valid option!");
			}
			System.out.println(choice);
			System.out.println("Do you want to continue? yes/no");
			choice = sc.next();
			System.out.println(choice);
		} while (choice.equalsIgnoreCase("yes"));
		sc.close();
		br.close();
	}
}