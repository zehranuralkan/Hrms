package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.ProgrammingLanguageService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorDataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import com.example.Hrms.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
private ProgrammingLanguageDao programmingLanguageDao;
@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
	super();
	this.programmingLanguageDao = programmingLanguageDao;
}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAll());

	}

	@Override
	public DataResult<ProgrammingLanguage> getById(int id) {
		var result = this.programmingLanguageDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<ProgrammingLanguage>("Programlama dili bulunamadı")
								: new SuccessDataResult<ProgrammingLanguage>(result.get());

	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Programlama dili eklendi");
	}

}
