package com.company.dao;

import java.util.List;

import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;

public class EmployeeDaoDBImpl implements EmployeeDAO {

	@Override
	public Employee findByEmpId(int empId) throws EmployeeNotFoundException {
		return null;
	}

	@Override
	public void add(Employee employee) {
		
	}

	@Override
	public Employee update(int id, Employee newEmp) throws EmployeeNotFoundException {
		return null;
	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
