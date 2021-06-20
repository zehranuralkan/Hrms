package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
List<JobExperience> getByJobSeeker_Id(int user_id);
}
