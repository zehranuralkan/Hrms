package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobExperienceService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.JobExperience;
@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<List<JobExperience>> getByJobSeekerId(@RequestParam int user_id){
		return this.jobExperienceService.getByJobSeekerId(user_id);
	}

	@GetMapping("/getByJobSeekerIdAndReverseSort")
	public DataResult<List<JobExperience>> getByJobSeekerIdAndReverseSort(@RequestParam int user_id){
		return this.jobExperienceService.getByJobSeekerIdAndReverseSort(user_id);
	}
	@GetMapping("/getById")
	DataResult<List<JobExperience>>getById(@RequestParam int id)
	{
		return this.jobExperienceService.getById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}

	}

