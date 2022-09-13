package com.company.ui;

import java.util.List;
import java.util.Scanner;

import com.company.exceptions.EmployeeAlreadyExistsException;
import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;
import com.company.service.EmployeeService;
import com.company.service.EmployeeServiceImpl;

public class CliMain {
	public static void main(String[] args) {
		System.out.println("----- Welcome to Employee Management System -----");

		EmployeeService service = new EmployeeServiceImpl();

		boolean flag = false;

		do {
			System.out.println("[1] Show All Employees");
			System.out.println("[2] Add a New Employee");
			System.out.println("[3] Update an Existing Employee");
			System.out.println("[4] Delete an Existing Employee");
			System.out.println("[5] Delete All Employees");
			System.out.println("Enter Your Choice >>>");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				List<Employee> employees = service.showAllEmployees();
				if (employees.size() == 0)
					System.out.println("No Employees In Repository");
				employees.forEach(System.out::println); // method reference since Java 1.8
				break;

			case 2:
				System.out.println("Enter empID, FirstName, LastName, Email, Salary");
				List<Employee> emps = null;
				try {
					emps = service.addEmployee(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(),
							scanner.nextDouble());
					emps.forEach(System.out::println);
				} catch (EmployeeAlreadyExistsException e2) {
					System.out.println(e2.getMessage());
				}
				
				break;

			case 3:
				System.out.println("Enter empId of the Employee which will be updated >>>");
				int empId = scanner.nextInt();
				try {
					service.findEmployeeById(empId);
					System.out.println("Enter Employee Info to be Updated!!");
					try {
						service.updateEmployee(empId, empId, scanner.next(), scanner.next(), scanner.next(),
								scanner.nextDouble());
					} catch (EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
				} catch (EmployeeNotFoundException e1) {
					System.out.println(e1.getMessage());
				}

				break;
			case 4:
				System.out.println("Enter empId of the Employee which will be deleted >>>");
				try {
					service.deleteAnEmployee(scanner.nextInt());
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				service.deleteAllEmployees();
				break;

			default:
				System.out.println("Invalid Input. Try Again!!");
				break;
			}

			System.out.println("Do You Wanna Continue ? [Y] | [N]");
			char ch = scanner.next().charAt(0);
			if (ch == 'Y' || ch == 'y')
				flag = true;
			else
				flag = false;
		} while (flag);
	}

}
