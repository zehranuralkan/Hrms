package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
List<JobSeeker> getByEmail(String email);
List<JobSeeker> getByIdentityNumber (String identityNumber);

}
