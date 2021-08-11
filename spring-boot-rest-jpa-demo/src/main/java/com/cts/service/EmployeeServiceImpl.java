package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException{
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		throw new EmployeeNotFoundException("Emplyee not Present with id: " + id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteById(int id) throws EmployeeNotFoundException{
		try {
			employeeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("Emplyee not Present with id: " + id);
		}
	}

}
