package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.ForeignLanguageService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("api/foreignLanguages")
public class ForeignLanguagesController {
private ForeignLanguageService foreignLanguageService;
@Autowired
public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
	super();
	this.foreignLanguageService = foreignLanguageService;
}
@GetMapping("/getAll")
public DataResult<List<ForeignLanguage>> getAll(){
	return this.foreignLanguageService.getAll();
}

@GetMapping("/getById")
public DataResult<ForeignLanguage> getById(@RequestParam int id){
	return this.foreignLanguageService.getById(id);
}

@PostMapping("/add")
public Result add(@RequestBody ForeignLanguage foreignLanguage) {
	return this.foreignLanguageService.add(foreignLanguage);
}
}
