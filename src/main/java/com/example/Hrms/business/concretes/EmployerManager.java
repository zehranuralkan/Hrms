package com.example.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.Rules;
import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.core.abstracts.VerificationService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.EmployerDao;
import com.example.Hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private VerificationService verificationService;
	@Autowired
	public EmployerManager(EmployerDao employerDao, VerificationService verificationService) {
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");

	}

	@Override
	public Result add(Employer employer) {
		Result result=Rules.run(nullControl(employer),webAdressControl(employer.getWebSite(),employer.getEmail()),existEmail(employer.getEmail()),realPhoneNumber(employer.getPhoneNumber()));
		if(result.isSuccess()) {
			this.employerDao.save(employer);
			verificationService.sendVerificationCode(employer.getEmail());
			return new SuccessResult("İş veren sisteme eklendi.E-mail adresine doğrulama kodu gönderilmiştir.");
		}
		return result;
	}
	private Result nullControl(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getId()) || Objects.isNull(employer.getPassword()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getWebSite())) {
			return new ErrorResult("bu alanlar boş bırakılamaz.");
		}
		return new SuccessResult();
	}
	

private Result existEmail(String email) {
	if (this.employerDao.getByEmail(email).stream().count() !=0) {
		return new ErrorResult("Bu E mail adresi kayıtlı.");
	}
	return new SuccessResult();
}

private Result webAdressControl(String webAddress, String email) {
	String emailSplit= email.split("@")[1];
	
	if (!webAddress.contains(emailSplit)) {
		return new ErrorResult("email,web sitenin domainine sahip olmalıdır.");
	}
	return new SuccessResult();
}
private Result realPhoneNumber(String phoneNumber) {
	String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	Pattern pattern=Pattern.compile(patterns);
	Matcher matcher=pattern.matcher(phoneNumber);
	if(!matcher.matches()) {
		return new ErrorResult("Telefon Numarası Geçersiz");
	}
	return new SuccessResult();
	
}
	@Override
	public DataResult<List<Employer>> getByEmail(String email) {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmail(email));

	}

}






