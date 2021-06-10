package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobTitleService;
import com.example.Hrms.dataAccess.abstracts.JobTitleDao;
import com.example.Hrms.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService{
private JobTitleDao jobTitleDao;
@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
	super();
	this.jobTitleDao = jobTitleDao;
}
	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}



}
