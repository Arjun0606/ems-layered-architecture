package com.company.service;

import java.util.List;

import com.company.dao.EmployeeDAO;
import com.company.dao.EmployeeDAOImpl;
import com.company.exceptions.EmployeeAlreadyExistsException;
import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl() {
		this.employeeDAO = new EmployeeDAOImpl();
//		this.employeeDAO = new EmployeeDBImpl();
	}

	@Override
	public List<Employee> addEmployee(int empId, String fn, String ln, String email, double salary) throws EmployeeAlreadyExistsException {
		Employee employee = new Employee(empId, fn, ln, email, salary);

		employeeDAO.add(employee);

		return employeeDAO.showAll();
	}

	@Override
	public void updateEmployee(int empId, int id, String fn, String ln, String email, double salary)
			throws EmployeeNotFoundException {
		Employee employee = new Employee(empId, fn, ln, email, salary);
		employeeDAO.update(empId, employee);
	}

	@Override
	public List<Employee> showAllEmployees() {
		return employeeDAO.showAll();
	}

	@Override
	public List<Employee> deleteAnEmployee(int id) throws EmployeeNotFoundException {
		employeeDAO.delete(id);
		return employeeDAO.showAll();

	}

	@Override
	public void deleteAllEmployees() {
		employeeDAO.deleteAll();
	}

	@Override
	public Employee findEmployeeById(int empId) throws EmployeeNotFoundException {
		return employeeDAO.findByEmpId(empId);
	}

}
