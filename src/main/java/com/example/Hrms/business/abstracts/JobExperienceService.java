package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
DataResult<List<JobExperience>>getAll();

DataResult<List<JobExperience>>getByJobSeekerId(int user_id);

DataResult<List<JobExperience>>getByJobSeekerIdAndReverseSort(int user_id);

DataResult<List<JobExperience>>getById(int id);

Result add(JobExperience jobExperience);
}
