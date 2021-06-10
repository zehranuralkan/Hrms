package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
@Data
@Entity
@Table(name="jobtitles")
public class JobTitle {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="jobname")
private String jobTitle;
public JobTitle() {
	
}
@Autowired
public JobTitle(int id, String jobTitle) {
	super();
	this.id=id;
	this.jobTitle=jobTitle;
}
}
