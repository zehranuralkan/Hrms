package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.ProgrammingLanguageService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;
@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
@GetMapping("/getAll")
public DataResult<List<ProgrammingLanguage>> getAll(){
	return this.programmingLanguageService.getAll();
}

@GetMapping("/getById")
public DataResult<ProgrammingLanguage> getById(@RequestParam int id){
	return this.programmingLanguageService.getById(id);
}

@PostMapping("/add")
public Result add(@RequestBody ProgrammingLanguage programmingLanguage) {
	return this.programmingLanguageService.add(programmingLanguage);
}

}
