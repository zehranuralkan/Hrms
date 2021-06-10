package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.JobSeeker;

@RestController
@Controller("/api/jobseekers")
public class JobSeekerController {
private JobSeekerService jobSeekerService;
@Autowired
public JobSeekerController(JobSeekerService jobSeekerService) {
	super();
	this.jobSeekerService = jobSeekerService;
}
@GetMapping("/getall")
public DataResult<List<JobSeeker>> getAll()
{
	return this.jobSeekerService.getAll();
}
@PostMapping("/add")
public Result add(JobSeeker jobSeeker) {
	return this.jobSeekerService.add(jobSeeker);
}
}
