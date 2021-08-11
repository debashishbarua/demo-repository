package com.cts.service;

import java.util.List;

import com.cts.model.Employee;

public interface EmployeeService {	
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee createEmployee(Employee employee);
	public void deleteById(int id);

}
