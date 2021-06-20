package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
DataResult<List<ProgrammingLanguage>>getAll();
DataResult<ProgrammingLanguage>getById(int id);
Result add(ProgrammingLanguage programmingLanguage);
}
