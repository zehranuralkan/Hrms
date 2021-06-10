package com.example.Hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.example.Hrms.core.abstracts.VerificationService;
@Service
public class VerificationManager implements VerificationService{

	@Override
	public boolean sendVerificationCode(String email) {
			return true;
	}

}
