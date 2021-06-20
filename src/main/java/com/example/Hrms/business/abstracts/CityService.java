package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.City;

public interface CityService {
Result add(City city);
DataResult<List<City>> getCities();
}
