package com.example.demo.test.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.test.entity.EmployeeEntity;
import com.example.demo.test.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String viewEmployees(
            Model model,
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {

        model.addAttribute("employees", employeeService.getAllEmployees(pageable));
        return "employees";
    }

    @GetMapping("/employees/new")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeEntity employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return "create_employee";
        }

        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.editEmployee(id));
        return "edit_employee";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
