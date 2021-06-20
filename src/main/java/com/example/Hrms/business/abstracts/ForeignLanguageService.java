package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
DataResult<List<ForeignLanguage>> getAll();

DataResult<ForeignLanguage> getById(int id);
Result add(ForeignLanguage foreignLanguage);
}
