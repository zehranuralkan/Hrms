package com.example.Hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.School;


public interface SchoolService {
DataResult<List<School>>getAll();

Result add(School school);
DataResult<List<School>>getByJobSeekerId(int user_id);

DataResult<List<School>>getByJobSeekerAndReverseSort(int user_id);


DataResult<School> getById(int id);

}
