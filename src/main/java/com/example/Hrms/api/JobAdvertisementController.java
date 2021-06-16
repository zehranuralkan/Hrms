package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobAdvertisementService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
private JobAdvertisementService jobAdvertisementService;
@Autowired
public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
	super();
	this.jobAdvertisementService = jobAdvertisementService;
}
@GetMapping("/api/getadvertisement")
public DataResult<List<JobAdvertisement>>getAll(){
	return this.jobAdvertisementService.getAll();
}
@PostMapping("/api/addjobadvertisement")
public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	return this.jobAdvertisementService.add(jobAdvertisement);
	
}
@GetMapping("getByCity")
public DataResult<JobAdvertisement>getByCity(@RequestParam int cityId){
	return null;
}

@GetMapping("getAllByPage")
public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize){
	return this.jobAdvertisementService.getAll(pageNo, pageSize);
}

}
