package com.example.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.Rules;
import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
private JobSeekerDao jobSeekerDao;
@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
	super();
	this.jobSeekerDao = jobSeekerDao;
}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"iş arayanlar listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		Result result=Rules.run(CheckIdentityNumber(jobSeeker),
				nullControl(jobSeeker),
				Tc(jobSeeker.getIdentityNumber()),
			    eMail(jobSeeker.getEmail()),
			    eMailFormat(jobSeeker.getEmail()));
if (result.isSuccess()) {
			
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult(jobSeeker.getFirstName()+" "+jobSeeker.getLastName()+ " iş arayan aday eklendi");
		}
		
		return result;
	}
private Result CheckIdentityNumber(JobSeeker jobSeeker) {
	if(jobSeeker.getIdentityNumber().length()!=11) {
		return new ErrorResult("Tc 11 haneli olmalıdır");
	}
	return new SuccessResult();
}

private Result nullControl(JobSeeker jobSeeker) {
if(Objects.isNull(jobSeeker.getBirthYear())
		||  Objects.isNull(jobSeeker.getEmail()) 
		|| Objects.isNull(jobSeeker.getId()) 
		|| Objects.isNull(jobSeeker.getFirstName()) 
		|| Objects.isNull(jobSeeker.getIdentityNumber())
		|| Objects.isNull(jobSeeker.getLastName())
		|| Objects.isNull(jobSeeker.getPassword())) {

	return new ErrorResult("Bu alanlar boş bırakılamaz!");
}
return new SuccessResult();
}
	
private Result Tc(String identitiyNumber) {
if(jobSeekerDao.getByIdentityNumber(identitiyNumber).stream().count()!=0) {
	return new ErrorResult("Girdiğiniz Tc kullanılmakta.");
}
return new SuccessResult();

}

private Result eMail(String email) {
if(jobSeekerDao.getByEmail(email).stream().count()!=0) {
	return new ErrorResult("Girdiğiniz email kayıtlı");
}
return new SuccessResult();
}
public static final Pattern validEmail = Pattern.compile(
		"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
		Pattern.CASE_INSENSITIVE);

private Result eMailFormat(String email) {
	if(!validEmail.matcher(email).find()) {
		return new ErrorResult("Geçersiz e mail adresi");
	}
	return new SuccessResult();
}
}
