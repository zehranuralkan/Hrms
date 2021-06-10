package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
List<User> getById(int id);
List<User> getByEmail(String email);
}
