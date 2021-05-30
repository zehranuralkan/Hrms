package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="jobtitles")
public class JobTitle {
	
@Id
@GeneratedValue
@Column(name="id")
private int id;
@Column(name="jobname")
private String jobTitle;
public JobTitle() {
	
}
public JobTitle(int id, String jobTitle) {
	super();
	this.id=id;
	this.jobTitle=jobTitle;
}
}
