package com.example.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.test.entity.EmployeeEntity;
import com.example.demo.test.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@Controller
public class EmployeeController {
public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


private EmployeeService employeeService;

@GetMapping("/employees")
public String viewHomepage(Model model) {
	model.addAttribute("employees", employeeService.listallEmployees());
	return "employees";
}

@GetMapping("/employees/new")
public String addEmployee(Model model) {
	EmployeeEntity employee =new EmployeeEntity();
	model.addAttribute("employee",employee);
	return "create_employee";
}

@PostMapping("/employees")
public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
	employeeService.addEmployee(employee);
	return "redirect:/employees";
}

@GetMapping("employees/edit/{id}")

public String editEmployee(@PathVariable Long id,Model model) {
model.addAttribute("employee", employeeService.editEmployee(id));
	return "edit_employee";
}
	

@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

@GetMapping("/employees")
public Page<Employee> getAllEmployees(
        @PageableDefault(size = 10, sort = "id") Pageable pageable) {
    return employeeService.getAllEmployees(pageable);
}
}


