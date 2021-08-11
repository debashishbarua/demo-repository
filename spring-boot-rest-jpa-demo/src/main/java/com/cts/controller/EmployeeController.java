package com.cts.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RequestMapping("/api")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Returing all employee http://localhost:9090/employees
	 * 
	 * @return
	 */

	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	/**
	 * Return employee by Id http://localhost:9090/employees/10
	 * 
	 * @return
	 */

	@GetMapping("/employees/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findById(id);
	}
	/**
	 * Use to create new Employee http://localhost:9090/employees
	 * @param employee
	 * @return
	 */

	@PostMapping("/employees")
	@ResponseBody
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

}
