package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.SchoolService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
private SchoolService schoolService;
@Autowired
public SchoolsController(SchoolService schoolService) {
	super();
	this.schoolService = schoolService;
}

@GetMapping("/getAll")
public DataResult<List<School>> getAll() {
	return this.schoolService.getAll();
}
@GetMapping("/getByJobSeekerId")
public DataResult<List<School>> getByJobSeekerId(int user_id) {
return this.schoolService.getByJobSeekerId(user_id);
}
@GetMapping("/getByJobSeekerAndReverseSort")
public DataResult<List<School>> getByJobSeekerAndReverseSort(int user_id) {
	return this.schoolService.getByJobSeekerAndReverseSort(user_id);
}
@GetMapping("/getById")
public DataResult<School> getById(int id) {
return this.schoolService.getById(id);	
}

@PostMapping("/add")
public Result add(@RequestBody School school) {
	return this.schoolService.add(school);
}
	
}
