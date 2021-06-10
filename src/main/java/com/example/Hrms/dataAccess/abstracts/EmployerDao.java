package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
List<Employer> getByEmail(String email);
}
