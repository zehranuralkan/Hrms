package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
