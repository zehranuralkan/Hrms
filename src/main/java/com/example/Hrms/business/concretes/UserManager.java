package com.example.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.Rules;
import com.example.Hrms.business.abstracts.UserService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.UserDao;
import com.example.Hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
private UserDao userDao;
@Autowired
	public UserManager(UserDao userDao) {
	super();
	this.userDao = userDao;
}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi");
	}

	@Override
	public Result add(User user) {
		Result result=Rules.run(nullControl(user),eMailFormat(user.getEmail()));
		if(result.isSuccess()) {
			this.userDao.save(user);
			return new SuccessResult("kullanıcı eklendi");
		}
		return new ErrorResult();
	}
	private Result nullControl(User user) {
		if (Objects.isNull(user.getId()) || Objects.isNull(user.getEmail())|| Objects.isNull(user.getPassword())) {
			return new ErrorResult("bu alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}
	
	public static final Pattern validEmail = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
			Pattern.CASE_INSENSITIVE);

	private Result eMailFormat(String email) {
		if (!validEmail.matcher(email).find()) {
			return new ErrorResult("Geçerli bir mail adresi girin!");
		}
		return new SuccessResult();
	}
	
	
	@Override
	public DataResult<List<User>> getById(int id) {
		return new SuccessDataResult<List<User>>(this.userDao.getById(id));
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		return new SuccessDataResult<List<User>>(this.userDao.getByEmail(email));
	}

}
