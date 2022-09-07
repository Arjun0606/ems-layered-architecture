package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import com.company.exceptions.EmployeeNotFoundException;
import com.company.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static List<Employee> employees;

	static {
		employees = new ArrayList<>();
		employees.add(new Employee(101, "aman", "kumar", "aman@email.com", 2500.00));
		employees.add(new Employee(102, "sai", "rutvik", "sai@email.com", 4500.00));
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public Employee update(int id, Employee newEmp) throws EmployeeNotFoundException {
		Employee emp = employees.stream().filter(e -> e.getEmpId() == id).findAny()
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found With empID : " + id));
		int empId = emp.getEmpId();
		employees.remove(emp);
		emp.setEmpId(empId);
		emp.setEmail(newEmp.getEmail());
		emp.setFirstName(newEmp.getFirstName());
		emp.setLastName(newEmp.getLastName());
		emp.setSalary(newEmp.getSalary());
		employees.add(emp);
		return emp;
	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		Employee emp = employees.stream().filter(e -> e.getEmpId() == id).findAny()
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found With empID : " + id));
		employees.remove(emp);
	}

	@Override
	public void deleteAll() {
		employees.clear();
	}

	@Override
	public List<Employee> showAll() {
		return employees;
	}

	@Override
	public Employee findByEmpId(int empId) throws EmployeeNotFoundException {
		return employees.stream().filter(e -> e.getEmpId() == empId).findAny()
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found With empID : " + empId));
	}

}
