package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobAdvertisementService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.example.Hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAvertisementManager implements JobAdvertisementService{
private JobAdvertisementDao jobAdvertisementDao;
@Autowired
	public JobAvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
	super();
	this.jobAdvertisementDao = jobAdvertisementDao;
}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(),"data listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("ilan eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCity_CityId(int cityId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_CityId(cityId),"data listelendi");
	}

}
