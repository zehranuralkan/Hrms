package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.User;

public interface UserService {
DataResult<List<User>> getAll();
Result add(User user);
DataResult<List<User>> getById(int id);
DataResult<List<User>> getByEmail(String email);
}
