package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.ForeignLanguageService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorDataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.example.Hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
private ForeignLanguageDao foreignLanguageDao;
@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
	super();
	this.foreignLanguageDao = foreignLanguageDao;
}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}

	@Override
	public DataResult<ForeignLanguage> getById(int id) {
		var result=this.foreignLanguageDao.findById(id);
		if (result.isEmpty())
			return new ErrorDataResult<ForeignLanguage>("yabancı dil bulunamadı");
		else
			return new SuccessDataResult<ForeignLanguage>("yabancı dil bulundu");
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("yabancı dil eklendi");
		
	}

}
