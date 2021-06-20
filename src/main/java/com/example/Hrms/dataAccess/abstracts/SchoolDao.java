package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer> {
List<School>getByJobSeeker_Id(int user_id);
}
