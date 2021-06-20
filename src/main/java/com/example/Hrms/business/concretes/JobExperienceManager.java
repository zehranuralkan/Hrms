package com.example.Hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobExperienceService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorDataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.Hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{
private JobExperienceDao jobExperienceDao;
@Autowired
public JobExperienceManager(JobExperienceDao jobExperienceDao) {
	super();
	this.jobExperienceDao = jobExperienceDao;
}
@Override
public DataResult<List<JobExperience>> getAll() {
	return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"data listelendi");
}
@Override
public DataResult<List<JobExperience>> getByJobSeekerId(int user_id) {
	var result=this.jobExperienceDao.getByJobSeeker_Id(user_id);
	return result.isEmpty()? new ErrorDataResult<List<JobExperience>>("İş tecrübesi bulunamadı"): new SuccessDataResult<List<JobExperience>>(result,"iş tecrübesi bulundu");
}
@Override
public DataResult<List<JobExperience>> getByJobSeekerIdAndReverseSort(int user_id) {
	var result=this.getByJobSeekerId(user_id);
	if(!result.isSuccess())
		return result;
	
	var sortedResult=result.getData().stream().sorted(Comparator.comparing(JobExperience::getFinishingDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed()).collect(Collectors.toList());
	return new SuccessDataResult<List<JobExperience>>(sortedResult);}

@Override
public Result add(JobExperience jobExperience) {
	this.jobExperienceDao.save(jobExperience);
	return new SuccessResult("İş tecrübesi eklendi");
}
@Override
public DataResult<List<JobExperience>> getById(int id) {
	var result=this.jobExperienceDao.findById(id);
	if (result.isEmpty())
		return new ErrorDataResult<List<JobExperience>>("iş tecrübesi bulunamadı");
	else
		return new SuccessDataResult<List<JobExperience>>("iş tecrübesi bulundu");	
}

}
