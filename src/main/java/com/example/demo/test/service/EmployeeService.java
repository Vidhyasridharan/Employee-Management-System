package com.example.demo.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.test.entity.EmployeeEntity;
@Service
public interface EmployeeService {

	 List<EmployeeEntity> listallEmployees();
	 EmployeeEntity addEmployee(EmployeeEntity employee);
	 EmployeeEntity editEmployee(Long id);
	 EmployeeEntity updateEmployee(EmployeeEntity employee);
	 void deleteEmployee(Long id);
}
public Page<Employee> getAllEmployees(Pageable pageable) {
    return employeeRepository.findAll(pageable);
}
