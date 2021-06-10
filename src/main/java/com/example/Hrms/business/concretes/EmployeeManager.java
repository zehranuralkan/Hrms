package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.EmployeeService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.EmployeeDao;
import com.example.Hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService{
private EmployeeDao employeeDao;
@Autowired
public EmployeeManager(EmployeeDao employeeDao) {
	super();
	this.employeeDao = employeeDao;
}
@Override
public DataResult<List<Employee>> getAll() {
	return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Çalışanlar listelendi");
}
@Override
public Result add(Employee employee) {
	this.employeeDao.save(employee);
	return new SuccessResult("Çalısan eklendi");
}
}
