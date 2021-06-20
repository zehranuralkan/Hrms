package com.example.Hrms.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.business.abstracts.BackgroundService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.Background;
import com.example.Hrms.entities.dtos.BackgroundDto;

@RestController
@RequestMapping("/api/backgrounds")
public class BackgroundsController {
private BackgroundService backgroundService;
@Autowired
public BackgroundsController(BackgroundService backgroundService) {
	super();
	this.backgroundService = backgroundService;
}
@GetMapping("/getAll")
public DataResult<List<Background>> getAll(){
	return this.backgroundService.getAll();
}

@PostMapping
public Result add(@RequestBody BackgroundDto backgroundDto) {
	return this.backgroundService.add(backgroundDto);
}
@PostMapping("/addImage")
public Result addImage(@RequestBody MultipartFile multipartFile, @RequestParam int id) throws IOException {
    return this.backgroundService.addImage(multipartFile, id);
}

@GetMapping("/getByCandidateId")
public DataResult<List<Background>> getByJobSeekerId(@RequestBody int jobSeekerId){
	return this.backgroundService.getByJobSeekerId(jobSeekerId);
}
}
