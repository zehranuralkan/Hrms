package com.example.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.CityService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
private CityService cityService;
@Autowired
public CitiesController(CityService cityService) {
	super();
	this.cityService = cityService;
}

@GetMapping("/getjobtitles")
public DataResult<List<City>>getAll(){
return this.cityService.getCities();
}

@PostMapping("/addjobtitles")
public void add(@RequestBody City city) {
	this.cityService.add(city);
}
}
