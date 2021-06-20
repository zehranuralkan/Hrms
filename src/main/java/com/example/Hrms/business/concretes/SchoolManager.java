package com.example.Hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.SchoolService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorDataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.SchoolDao;
import com.example.Hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"okullar listelendi");
		}
	

	@Override
	public DataResult<List<School>> getByJobSeekerId(int user_id) {
		var result=this.schoolDao.getByJobSeeker_Id(user_id);
		return result.isEmpty()? new ErrorDataResult<List<School>>("okul bulunamadı"): new SuccessDataResult<List<School>>(result,"okul bulundu");
	}

	@Override
	public DataResult<List<School>> getByJobSeekerAndReverseSort(int user_id) {
		var result=this.getByJobSeekerId(user_id);
		if(!result.isSuccess())
			return result;
		var sortedResult=result.getData().stream().sorted(Comparator.comparing(School::getFinishingDate,Comparator.nullsLast(Comparator.naturalOrder())).reversed()).collect(Collectors.toList());
		return new SuccessDataResult<List<School>>(sortedResult);
	}

	@Override
	public DataResult<School> getById(int id) {
		var result=this.schoolDao.findById(id);
		return result.isEmpty()? new ErrorDataResult<School>("okul bulunamadı"):new SuccessDataResult<School>(result.get(),"okul bulundu");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("okul eklendi");
	}



	


}
