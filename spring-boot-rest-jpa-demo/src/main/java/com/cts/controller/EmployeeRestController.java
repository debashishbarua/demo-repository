package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Returing all employee http://localhost:9090/employees
	 * 
	 * @return
	 */

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	/**
	 * Return employee by Id http://localhost:9090/employees/10
	 * @param id
	 * @return
	 * @throws EmployeeNotFoundException
	 */

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException{
		return employeeService.findById(id);
	}
	/**
	 * Use to create new Employee http://localhost:9090/employees
	 * @param employee
	 * @return
	 */

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	/**
	 * Used for  delete employee by Id
	 * @param id
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@DeleteMapping("employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
		 employeeService.deleteById(id);
		 return "Employee Deleted With id : " +id;
	}

}
