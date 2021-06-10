package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	private EmployerService employerService;
@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
@GetMapping("/getall")
public DataResult<List<Employer>>getall()
{
	return this.employerService.getAll();
	}
@PostMapping("/add")
public Result add(Employer employer) {
	return this.employerService.add(employer);
}
}
