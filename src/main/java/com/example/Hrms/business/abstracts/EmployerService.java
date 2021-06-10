package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.Employer;

public interface EmployerService {
DataResult<List<Employer>> getAll();
Result add(Employer employer);
DataResult<List<Employer>> getByEmail(String email);
}
