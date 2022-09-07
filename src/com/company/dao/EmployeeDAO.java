package com.company.dao;

import java.util.List;

import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;

public interface EmployeeDAO {
	Employee findByEmpId(int empId) throws EmployeeNotFoundException;

	void add(Employee employee);

	Employee update(int id, Employee newEmp) throws EmployeeNotFoundException;

	void delete(int id) throws EmployeeNotFoundException;

	void deleteAll();

	List<Employee> showAll();

}
