package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.CityService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.CityDao;
import com.example.Hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {
	@Autowired
public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

private CityDao cityDao;
	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("şehir eklendi");
	}

	@Override
	public DataResult<List<City>> getCities() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"şehirler listelendi");
	}

}
