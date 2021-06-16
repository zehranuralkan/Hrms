package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
DataResult<List<JobAdvertisement>>getAll();
DataResult<List<JobAdvertisement>>getAll(int pageNo,int pageSize);
Result add(JobAdvertisement jobAdvertisement);
DataResult<List<JobAdvertisement>>getByCity_CityId(int cityId);


}
