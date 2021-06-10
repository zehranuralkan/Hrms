package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.EmployeeService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private EmployeeService employeeService;
@Autowired
public EmployeeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}
@GetMapping("/getall")
public DataResult<List<Employee>> getAll(){
	return this.employeeService.getAll();
}
@PostMapping("/add")
public Result add(Employee employee) {
	return this.employeeService.add(employee);
}

}
