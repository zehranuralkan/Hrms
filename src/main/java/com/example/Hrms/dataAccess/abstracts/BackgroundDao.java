package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Background;

public interface BackgroundDao extends JpaRepository<Background,Integer>{
List<Background>getByJobSeeker_Id(int user_id);
}
