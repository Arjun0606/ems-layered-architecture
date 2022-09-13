package com.company.service;

import java.util.List;

import com.company.exceptions.EmployeeAlreadyExistsException;
import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;

public interface EmployeeService {

	Employee findEmployeeById(int empId) throws EmployeeNotFoundException;

	List<Employee> showAllEmployees();

	List<Employee> deleteAnEmployee(int id) throws EmployeeNotFoundException;

	void deleteAllEmployees();

	List<Employee> addEmployee(int empId, String fn, String ln, String email, double salary) throws EmployeeAlreadyExistsException;

	void updateEmployee(int empId, int id, String fn, String ln, String email, double salary)
			throws EmployeeNotFoundException;

}
